import pandas as pd
import requests
import constants as const

API_KEY = const.MOVIE_DB_API_KEY

def fetch_movie_link(movie_id):
    """Generate movie link based on ID."""
    return f"https://www.themoviedb.org/movie/{movie_id}"

def get_movie_poster(movie_id):
    """Generate poster link based on ID."""
    url = f"https://api.themoviedb.org/3/movie/{movie_id}?api_key={API_KEY}&language=en-US"
    try:
        response = requests.get(url)
        response.raise_for_status()
        data = response.json()
        poster_path = data.get('poster_path')
        if poster_path:
            full_path = f"https://image.tmdb.org/t/p/w500/{poster_path}"
            return full_path
        else:
            return None
    except requests.exceptions.RequestException as e:
        print(f"Error fetching movie poster for movie ID {movie_id}: {str(e)}")
        return None

def get_recommendations(movie, titles, cosine_sim):
    """
    This function computes similarity scores for a specific movie, sorts them,
    and retrieves metadata for recommended movies.
    """
    # Create a mapping of movie titles to their indices
    indices = pd.Series(movie.index, index=movie['title']).drop_duplicates()

    # Get indices of the target movies
    idx = {indices[t] for t in titles}

    # Initialize a dictionary to store similarity scores
    sim_scores = {}

    # Calculate the maximum similarity score for each movie
    for movie_idx in idx:
        sim = cosine_sim[movie_idx]
        for i, s in enumerate(sim):
            sim_scores[i] = max(s, sim_scores.get(i, 0))

    # Remove indices of target movies from the similarity scores
    for i in idx:
        del sim_scores[i]

    # Sort the similarity scores in descending order and select the top recommendations
    sim_scores = list(sorted(sim_scores.items(), key=lambda item: item[1], reverse=True))[:const.RECOMMENDATION_NUMBER]

    # Extract movie indices and similarity scores
    movie_indices = [i[0] for i in sim_scores]
    movie_similarity = [i[1] for i in sim_scores]

    # Create a DataFrame with recommended movie information
    recommendations = pd.DataFrame(zip(movie['id'].iloc[movie_indices], movie['title'].iloc[movie_indices], movie_similarity),
                                    columns=["movieId", "title", "score"])

    return recommendations