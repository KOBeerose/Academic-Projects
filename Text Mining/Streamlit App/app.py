# import packages
import streamlit as st
import os
import numpy as np
 
from sklearn.feature_extraction.text import TfidfVectorizer, CountVectorizer
 
# text preprocessing modules
from string import punctuation
 
# text preprocessing modules
from nltk.tokenize import word_tokenize
 
import nltk
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
import re  # regular expression
import joblib
 
import warnings
 
warnings.filterwarnings("ignore")
# seeding
np.random.seed(123)


from tensorflow.keras.preprocessing.text import Tokenizer
from tensorflow.keras.preprocessing.sequence import pad_sequences

# load stop words
stop_words = stopwords.words("english")


# function to clean the text
@st.cache
def text_cleaning(text, remove_stop_words=True, lemmatize_words=True):
    # Clean the text, with the option to remove stop_words and to lemmatize word
 
    # Clean the text
    text = re.sub(r"[^A-Za-z0-9]", " ", text)
    text = re.sub(r"\'s", " ", text)
    text = re.sub(r"http\S+", " link ", text)
    text = re.sub(r"\b\d+(?:\.\d+)?\s+", "", text)  # remove numbers
 
    # Remove punctuation from text
    text = "".join([c for c in text if c not in punctuation])
 
    # Optionally, remove stop words
    if remove_stop_words:
        text = text.split()
        text = [w for w in text if not w in stop_words]
        text = " ".join(text)
 
    # Optionally, shorten words to their stems
    if lemmatize_words:
        text = text.split()
        lemmatizer = WordNetLemmatizer()
        lemmatized_words = [lemmatizer.lemmatize(word) for word in text]
        text = " ".join(lemmatized_words)
 
    # Return a list of words
    return text

from nltk.corpus import movie_reviews
import pandas as pd
negative_fileids = movie_reviews.fileids('neg')
positive_fileids = movie_reviews.fileids('pos')

negative_features = pd.DataFrame(
    {'review':movie_reviews.raw(fileids=[f]),'label': 'neg'} for f in negative_fileids
)

positive_features = pd.DataFrame(
    {'review':movie_reviews.raw(fileids=[f]),'label': 'pos'} for f in positive_fileids
)

Dataframe = pd.concat([positive_features, negative_features], ignore_index=True)

Dataframe['label'] = Dataframe['label'].apply(lambda  x: 1 if x=="pos" else 0)

sentences_train =  Dataframe['review']

# definir notre tokenizer
tokenizer = Tokenizer(num_words=5000)
tokenizer.fit_on_texts(sentences_train)

# functon to make prediction
@st.cache
def make_prediction(review):
 
    # clearn the data
    clean_review = text_cleaning(review)
    desc = tokenizer.texts_to_sequences([clean_review])
    desc = pad_sequences(desc, padding='post', maxlen=100)
    # load the model and make prediction
    model = joblib.load("C:\\Users\\tahae\\Coding\\Academic-Projects\\Text Mining\\Lab2\\model.pkl")
 

    # faire une prediction sur la description
    prediction_test = model.predict(desc)
    
    # obtenir la classe du text
    result = np.argmax(prediction_test)

    # obtenir la certitude du prediction
    probability = prediction_test[0][result]
    
 
    return result, probability

print(make_prediction("good and amazing film"))
