import scipy.sparse
import pickle
from sklearn.metrics.pairwise import linear_kernel, cosine_similarity
from constants import RECOMMENDATION_NUMBER
from helper.utils import get_recommendations

def load_movie_scores():
    """Load and return the top movies based on scores."""
    with open('data/movie_scores.pickle', 'rb') as handle:
        movies = pickle.load(handle)
    movies = movies.head(RECOMMENDATION_NUMBER)
    movies = movies[["id", "title", "score"]]
    movies.columns = ["movieId", "title", "score"]
    return movies

def create_cosine_similarity_matrix(tfidf_matrix):
    """Create and return a cosine similarity matrix based on the given TF-IDF matrix."""
    return linear_kernel(tfidf_matrix, tfidf_matrix)

def create_cosine_similarity_matrix_count(count_matrix):
    """Create and return a cosine similarity matrix based on the given count matrix."""
    return cosine_similarity(count_matrix, count_matrix)

def content_recommendations(movie, titles, cosine_sim):
    """Generate content-based recommendations using the given similarity matrix."""
    return get_recommendations(movie, titles, cosine_sim)
