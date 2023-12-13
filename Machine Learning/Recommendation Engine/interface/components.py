import streamlit as st_lib
import constants as const_lib
from helper.utils import fetch_movie_link, get_movie_poster

def create_movie_widget(config):
    """This function generates empty slots for all recommended movies
    and adds description and title from the corresponding config file"""
    with st_lib.expander(config["title"]):
        st_lib.markdown(config["description"])

    movie_layouts = st_lib.columns(const_lib.RECOMMENDATION_NUMBER)
    for layout in movie_layouts:
        with layout:
            st_lib.empty()

    return movie_layouts

def show_basic_info(movie_layouts, display_score):
    """This function displays a simple description"""
    for layout in zip(movie_layouts):
        with movie_layouts:
            st_lib.markdown(f"<a style='display: block; text-align: center;' href='{l}'>{t}</a>", unsafe_allow_html=True)
            st_lib.image(p)
            if display_score:
                st_lib.write(round(s, 3))

def display_movie_info(recommended_movies, movie_layouts, display_score):
    """This function fetches all the data we want to display and places it on the webpage"""
    movie_identifiers = recommended_movies["movieId"]
    movie_titles = recommended_movies["title"]
    movie_ratings = recommended_movies["score"]
    posters = [get_movie_poster(i) for i in movie_identifiers]
    links = [fetch_movie_link(i) for i in movie_identifiers]
    for layout, t, s, p, l in zip(movie_layouts, movie_titles, movie_ratings, posters, links):
        with layout:
            with open('style.css') as f:
                st_lib.markdown(f"<a style='display: block; text-align: center; color: #00ffc8;' href='{l}'>{t}</a>", unsafe_allow_html=True)
                st_lib.image(p)
                if display_score:
                    st_lib.write(round(s, 3))