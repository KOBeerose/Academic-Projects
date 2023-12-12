main_page_cfg = dict(
    description="""K-means clustering is one of the simplest and popular unsupervised machine learning algorithms.
    Typically, unsupervised algorithms make inferences from datasets using only input vectors without referring to 
    known, or labelled, outcomes. 
    \nYou’ll define a target number k, which refers to the number of centroids you need in the dataset.
    A centroid is the imaginary or real location representing the center of the cluster.
    Every data point is allocated to each of the clusters through reducing the in-cluster sum of squares.
    \nIn other words, the K-means algorithm identifies k number of centroids, and then allocates every data point
    to the nearest cluster, while keeping the centroids as small as possible.""",
)

score_based_cfg = dict(
    title="Score Based",
    description="""
    this system offer generalized recommendations to every user, based on movie popularity and/or genre. 
    The System recommends the same movies to users with similar demographic features. 
    Since each user is different , this approach is considered to be too simple. 
    The basic idea behind this system is that movies that are more popular and critically acclaimed will have a higher probability of being liked by the average audience.\n
    \n- we need a metric to score or rate movie
    \n- Calculate the score for every movie
    \n- Sort the scores and recommend the best rated movie to the users.
    We can use the average ratings of the movie as the score but using this won't be fair enough 
    \nsince a movie with 8.9 average rating and only 3 votes cannot be considered better than the movie with 7.8 as as average rating but 40 votes. 
    So, I'll be using IMDB's weighted rating (wr) which is given as
    \n![](https://image.ibb.co/jYWZp9/wr.png)
    \nwhere:
    \n- v is the number of votes for the movie;
    \n- m is the minimum votes required to be listed in the chart;
    \n- R is the average rating of the movie; And
    \n- C is the mean vote across the whole report
    """
)

content_based_cfg = dict(
    title="Content Based",
    description="""
    Content based filtering suggest similar items based on a particular item. This system uses item metadata, such as genre, director, description, actors, etc. for movies, to make these recommendations. 
    The general idea behind these recommender systems is that if a person liked a particular item, he or she will also like an item that is similar to it.
    
    In this recommender system the content of the movie is used to find its similarity with other movies. Then the movies that are most likely to be similar are recommended
    compute pairwise similarity scores for all movies based on their overview and recommend movies based on that similarity score. 
    
    We will be using the cosine similarity to calculate a numeric quantity that denotes the similarity between two movies. 
    We use the cosine similarity score since it is independent of magnitude and is relatively easy and fast to calculate. Mathematically, it is defined as follows:  
    ![](data:image/png;base64,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)
    """
)

content_extra_based_cfg = dict(
    title="Content Based (extra)",
    description="""
    Content based filtering suggest similar items based on a particular item. This system uses item metadata, such as genre, director, description, actors, etc. for movies, to make these recommendations. 
    The general idea behind these recommender systems is that if a person liked a particular item, he or she will also like an item that is similar to it.
    
    It goes without saying that the quality of our recommender would be increased with the usage of better metadata. That is exactly what we are going to do in this section. 
    We are going to build a recommender based on the following metadata: the 3 top actors, the director, related genres and the movie plot keywords.

    From the cast, crew and keywords features, we need to extract the three most important actors, the director and the keywords associated with that movie
    """
)