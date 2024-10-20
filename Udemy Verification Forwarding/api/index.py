import os
import base64
import re
import logging
from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
from flask import Flask, render_template
from dotenv import load_dotenv
from datetime import datetime
import timeago 

# Initialize logging
logging.basicConfig(level=logging.INFO)

# Load environment variables
load_dotenv()

# Initialize Flask app and explicitly set the templates folder
app = Flask(__name__, template_folder=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'templates')))

# Function to authenticate and get credentials using refresh tokens from environment variables
def get_credentials():
    try:
        creds = None
        # Fetch tokens and credentials from environment variables
        refresh_token = os.environ.get('GOOGLE_REFRESH_TOKEN')
        client_id = os.environ.get('GOOGLE_CLIENT_ID')
        client_secret = os.environ.get('GOOGLE_CLIENT_SECRET')
        token_uri = os.environ.get('GOOGLE_TOKEN_URI')

        # Log the presence of environment variables
        if not refresh_token:
            logging.error("GOOGLE_REFRESH_TOKEN is missing!")
        if not client_id:
            logging.error("GOOGLE_CLIENT_ID is missing!")
        if not client_secret:
            logging.error("GOOGLE_CLIENT_SECRET is missing!")
        if not token_uri:
            logging.error("GOOGLE_TOKEN_URI is missing!")

        # Ensure all credentials are present
        if refresh_token and client_id and client_secret and token_uri:
            creds = Credentials(
                None,
                refresh_token=refresh_token,
                token_uri=token_uri,
                client_id=client_id,
                client_secret=client_secret
            )
            # Refresh the credentials if they are expired
            if creds and creds.expired and creds.refresh_token:
                creds.refresh(Request())

        if not creds:
            logging.error("Credentials could not be created! Missing environment variables.")
        return creds
    except Exception as e:
        logging.error(f"Error during credential handling: {str(e)}")
        return str(e)

# Function to get Udemy verification code from Gmail
def get_udemy_verification_code():
    try:
        creds = get_credentials()
        if isinstance(creds, str):
            logging.error(f"Error with credentials: {creds}")
            return {'error': f'Error with credentials: {creds}'}
        
        logging.info("Attempting to connect to Gmail API...")
        service = build('gmail', 'v1', credentials=creds)
        
        # Search for the latest Udemy verification email
        query = "from:no-reply@e.udemymail.com subject:Udemy"
        logging.info("Fetching messages from Gmail...")
        results = service.users().messages().list(userId='me', q=query, maxResults=1).execute()
        messages = results.get('messages', [])

        if not messages:
            logging.warning("No Udemy verification code found.")
            return {'error': "No Udemy verification code found."}

        email_list = []
        for message_data in messages:
            message_id = message_data['id']
            message = service.users().messages().get(userId='me', id=message_id).execute()

            headers = message['payload']['headers']
            subject = next(header['value'] for header in headers if header['name'] == 'Subject')
            sender = next(header['value'] for header in headers if header['name'] == 'From')

            # Extract the body and attempt to find the 6-digit verification code
            body = ""
            for part in message['payload']['parts']:
                if part['mimeType'] == 'text/plain':
                    body = base64.urlsafe_b64decode(part['body']['data']).decode('utf-8')
                    break

            # Use regex to capture the 6-digit verification code
            match = re.search(r'\d{6}', body)
            verification_code = match.group(0) if match else "No code found."

            # Extract the email's timestamp (internalDate is in milliseconds)
            timestamp_ms = int(message['internalDate'])  # Milliseconds since epoch
            email_date = datetime.fromtimestamp(timestamp_ms / 1000)  # Convert to datetime
            formatted_time = email_date.strftime("%I:%M %p")  # Format the time like "1:10 AM"
            time_ago = timeago.format(email_date, datetime.utcnow())  # Show relative time (e.g., "2 hours ago")

            # Append the data to the list
            email_list.append({
                'subject': subject,
                'sender': sender,
                'body': body,
                'verification_code': verification_code,
                'formatted_time': formatted_time,
                'time_ago': time_ago
            })

        logging.info("Successfully fetched email data.")
        return {'emails': email_list}
    
    except HttpError as http_err:
        logging.error(f"HTTP Error: {http_err}")
        return {'error': f'HTTP Error: {http_err}'}
    except Exception as e:
        logging.error(f"An error occurred: {str(e)}")
        return {'error': f'An error occurred: {str(e)}'}


# Route to show the loading page immediately
@app.route('/')
def home():
    return render_template('loading.html')

# Route to actually fetch emails in the background
@app.route('/fetch-emails')
def fetch_emails():
    email_data = get_udemy_verification_code()

    # If there's an error, render the error page
    if 'error' in email_data:
        return render_template('error.html', error=email_data['error'])

    return render_template('index.html', emails=email_data['emails'])

# Expose the Flask app to Vercel
if __name__ == '__main__':
    app.run(debug=True)
