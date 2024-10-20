from datetime import datetime
import os
import timeago
from flask import Flask, jsonify, render_template, request
from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from googleapiclient.discovery import build
from googleapiclient.errors import HttpError
import base64
import re
import logging

# Initialize logging
logging.basicConfig(level=logging.INFO)

# Load environment variables (assume Vercel or environment settings)
# load_dotenv() if you're using dotenv locally

app = Flask(__name__, static_url_path='', static_folder="../static", template_folder=os.path.abspath(os.path.join(os.path.dirname(__file__), '..', 'templates')))

def get_credentials():
    try:
        # Use environment variables for credentials
        refresh_token = os.environ.get('GOOGLE_REFRESH_TOKEN')
        client_id = os.environ.get('GOOGLE_CLIENT_ID')
        client_secret = os.environ.get('GOOGLE_CLIENT_SECRET')
        token_uri = os.environ.get('GOOGLE_TOKEN_URI')

        if refresh_token and client_id and client_secret and token_uri:
            creds = Credentials(
                None,
                refresh_token=refresh_token,
                token_uri=token_uri,
                client_id=client_id,
                client_secret=client_secret
            )
            if creds and creds.expired and creds.refresh_token:
                creds.refresh(Request())

        if not creds:
            logging.error("Credentials could not be created! Missing environment variables.")
        return creds
    except Exception as e:
        logging.error(f"Error during credential handling: {str(e)}")
        return str(e)

def get_udemy_verification_code(page_token=None):
    try:
        creds = get_credentials()
        if isinstance(creds, str):
            logging.error(f"Error with credentials: {creds}")
            return {'error': f'Error with credentials: {creds}'}
        
        service = build('gmail', 'v1', credentials=creds)

        # Search for Udemy emails, include pageToken for pagination
        query = "from:no-reply@e.udemymail.com subject:Udemy"
        request_params = {'userId': 'me', 'q': query, 'maxResults': 5}
        if page_token:
            request_params['pageToken'] = page_token

        results = service.users().messages().list(**request_params).execute()
        messages = results.get('messages', [])
        next_page_token = results.get('nextPageToken')

        if not messages:
            return {'error': "No Udemy verification code found."}

        email_list = []
        for message_data in messages:
            message_id = message_data['id']
            message = service.users().messages().get(userId='me', id=message_id).execute()

            headers = message['payload']['headers']
            subject = next(header['value'] for header in headers if header['name'] == 'Subject')
            sender = next(header['value'] for header in headers if header['name'] == 'From')

            # Extract the body and find the verification code
            body = ""

            # Handle both multipart and single-part emails
            if 'parts' in message['payload']:
                for part in message['payload']['parts']:
                    if part['mimeType'] == 'text/plain':
                        body = base64.urlsafe_b64decode(part['body']['data']).decode('utf-8')
                        break
            else:
                # If no parts, check the payload's body field directly
                if 'body' in message['payload'] and 'data' in message['payload']['body']:
                    body = base64.urlsafe_b64decode(message['payload']['body']['data']).decode('utf-8')

            # Use regex to capture the 6-digit verification code
            match = re.search(r'\d{6}', body)
            verification_code = match.group(0) if match else None  # Only proceed if a valid code is found

            # Skip emails without a valid verification code
            if not verification_code:
                continue  # Skip this email if no valid code was found

            # Extract timestamp
            timestamp_ms = int(message['internalDate'])  # Convert from ms to s
            email_date = datetime.fromtimestamp(timestamp_ms / 1000)
            formatted_time = email_date.strftime("%I:%M %p")
            time_ago = timeago.format(email_date, datetime.utcnow())

            email_list.append({
                'subject': subject,
                'sender': sender,
                'body': body,
                'verification_code': verification_code,
                'formatted_time': formatted_time,
                'time_ago': time_ago
            })

        return {'emails': email_list, 'next_page_token': next_page_token}

    except HttpError as http_err:
        logging.error(f"HTTP Error: {http_err}")
        return {'error': f'HTTP Error: {http_err}'}
    except Exception as e:
        logging.error(f"An error occurred: {str(e)}")
        return {'error': f'An error occurred: {str(e)}'}



# Route for loading the initial page
@app.route('/')
def home():
    email_data = get_udemy_verification_code()

    # If there's an error, render the error page
    if 'error' in email_data:
        return render_template('error.html', error=email_data['error'])

    return render_template('index.html', emails=email_data['emails'], next_page_token=email_data['next_page_token'])

# Route for fetching emails via AJAX (for infinite scroll)
@app.route('/fetch-emails')
def fetch_emails():
    # Get the pageToken from the request query parameters
    page_token = request.args.get('pageToken')

    # Fetch the next set of emails
    email_data = get_udemy_verification_code(page_token=page_token)

    # If there's an error, return the error as JSON
    if 'error' in email_data:
        return jsonify(email_data)

    # Return the emails and nextPageToken as JSON for infinite scroll
    return jsonify({
        'emails': email_data['emails'],
        'next_page_token': email_data['next_page_token']  # Ensure the next page token is passed
    })

if __name__ == '__main__':
    app.run(debug=True)
