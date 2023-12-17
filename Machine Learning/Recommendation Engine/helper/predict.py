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

def content_recommendations(movie, titles):
    """Create and return a cosine similarity matrix based on the given TF-IDF matrix.
    read matrix create similarity function and call main function"""
    tfidf_matrix = scipy.sparse.load_npz('data/tfidf_matrix.npz')
    cosine_sim = linear_kernel(tfidf_matrix, tfidf_matrix)
    return get_recommendations(movie, titles, cosine_sim)


def content_recommendations_plus(movie, titles):
    """Create and return a cosine similarity matrix based on the given count matrix.
    read matrix create similarity function and call main function"""
    count_matrix = scipy.sparse.load_npz("data/count_matrix.npz")
    cosine_sim = cosine_similarity(count_matrix, count_matrix)
    return get_recommendations(movie, titles, cosine_sim)

