import streamlit as st_lib
import streamlit.components.v1 as components_lib
import pickle as pickle_lib

import constants as const_lib
from content import score_cfg, content_cfg, content_plus_cfg
from interface.components import  create_movie_widget, show_basic_info, display_movie_info
from helper.predict import content_recommendations, weight_avg_recommendations, content_recommendations_plus

# Set the page configuration
st_lib.set_page_config(page_title="Recommender system", layout="wide")

# Apply custom CSS
with open('style.css') as style_file:
    st_lib.markdown(f'<style>{style_file.read()}</style>', unsafe_allow_html=True)

# Load the main movie data
with open('data/movie_df.pickle', 'rb') as data_file:
    movie_data = pickle_lib.load(data_file)

# Display the main title
st_lib.markdown('# Movie Recommender system')

# Create the search panel and search button
main_layout, search_layout = st_lib.columns([10, 1])
movie_options = main_layout.multiselect('Which movies do you like?', movie_data["title"].unique())
search_movies_btn = search_layout.button("search")

# Add widgets to the sidebar
num_recommended_movies = st_lib.sidebar.slider("Recommended movie number", min_value=5, max_value=10)
if num_recommended_movies:
    const_lib.RECOMMENDATION_NUMBER = num_recommended_movies
display_score = st_lib.sidebar.checkbox("Show score")

# Initialize movie widgets
score_based_col = create_movie_widget(score_cfg)
content_based_col = create_movie_widget(content_cfg)
content_plus_col = create_movie_widget(content_plus_cfg)

# Display recommended movies based on weighted average
score_based_recommended_movies = weight_avg_recommendations()
show_basic_info(score_based_col, display_score)

# Display recommended movies when the search button is clicked
if search_movies_btn:
    content_based_movies = content_recommendations(movie_data, movie_options)
    display_movie_info(content_based_movies, content_based_col, display_score)

    content_plus_movies = content_recommendations(movie_data, movie_options)
    display_movie_info(content_plus_movies, content_plus_col, display_score)
