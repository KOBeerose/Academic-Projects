main_page_configuration = dict(
    description="""K-means clustering is a straightforward and widely used unsupervised machine learning technique.
    Unsupervised algorithms typically analyze datasets using only input vectors without considering known or labeled outcomes. 
    \nIn K-means clustering, you define a target number 'k,' which represents the desired number of centroids in the dataset.
    A centroid is a theoretical or actual point representing the center of a cluster.
    The algorithm assigns each data point to the nearest cluster while minimizing the in-cluster sum of squares.
    \nIn essence, the K-means algorithm identifies 'k' centroids and assigns each data point to the nearest cluster, aiming to keep the centroids as compact as possible.""",
)

score_cfg = dict(
    title="Score-Based",
    description="""
    This system provides generalized recommendations to users based on movie popularity and/or genre. 
    It suggests the same movies to users with similar demographic characteristics. 
    However, this approach is considered simplistic because it assumes that all users with similar traits will have the same preferences. 
    The fundamental idea behind this system is that movies with higher popularity and critical acclaim are more likely to be liked by the general audience.\n
    \nTo achieve this, the following steps are taken:
    \n1. Assign a metric for scoring or rating movies.
    \n2. Calculate a score for each movie.
    \n3. Sort the scores and recommend the highest-rated movies to users.
    
    To calculate the score, we use IMDB's weighted rating formula, which takes into account the number of votes, minimum votes required, average rating, and mean vote across the entire dataset.
    """
)

content_cfg = dict(
    title="Content-Based",
    description="""
    Content-based filtering suggests similar items based on a particular item's characteristics. This system leverages item metadata, such as genre, director, description, actors, and more, to make these recommendations. 
    The underlying concept is that if a person enjoyed a specific item, they are likely to appreciate items that share similar attributes.
    
    In this recommender system, the content of a movie is used to identify its similarity with other movies. Movies that are most similar are then recommended.
    To calculate similarity, we employ the cosine similarity measure, which quantifies the similarity between two movies based on their overviews. The cosine similarity is chosen for its magnitude independence and computational efficiency.""",
)

content_plus_cfg = dict(
    title="Content-Based (Enhanced)",
    description="""
    Content-based filtering recommends similar items based on specific item characteristics. This system relies on item metadata, including genre, director, description, actors, and more, to provide recommendations. 
    The core concept is that individuals who liked a particular item are likely to enjoy items that share similar attributes.
    
    To enhance the quality of our recommender, we will use richer metadata, including the top 3 actors, director, related genres, and movie plot keywords. 
    From the cast, crew, and keywords features, we will extract the three most significant actors, the director, and the keywords associated with each movie.""",
)
