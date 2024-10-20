
from flask import Flask
from google.oauth2.credentials import Credentials
from googleapiclient.discovery import build
import re

app = Flask(__name__)

# Gmail API function to get verification code
def get_udemy_verification_code():
    creds = Credentials.from_authorized_user_file('token.json', ['https://www.googleapis.com/auth/gmail.readonly'])
    service = build('gmail', 'v1', credentials=creds)
    
    # Fetch the latest Udemy verification email
    results = service.users().messages().list(userId='me', q="subject:Udemy Verification").execute()
    messages = results.get('messages', [])
    
    if not messages:
        return "No code found."
    else:
        message = messages[0]
        msg = service.users().messages().get(userId='me', id=message['id']).execute()
        body = msg['snippet']

        # Extract the verification code from the email (assuming a 6-digit code)
        match = re.search(r'\b\d{6}\b', body)
        if match:
            return match.group(0)
        else:
            return "Code not found."

@app.route('/')
def display_code():
    code = get_udemy_verification_code()
    return f'<h1>Your Udemy Code: {{code}}</h1>'

# Export the app as a Vercel function handler
app = app
