# Movie Recommendation Engine

## Project Overview

The Movie Recommendation Engine is a machine learning project that provides movie recommendations based on different algorithms and data sources. It utilizes various data attributes such as movie credits, genres, keywords, and user ratings to generate personalized movie suggestions.

## Project Structure

The project directory structure is organized as follows:

```plaintext
C:\Users\taha\Coding\Academic-Projects\Machine Learning\Recommendation Engine
|-- .streamlit
|   |-- config.toml
|-- assets
|   |-- social_components.html
|-- data
|   |-- count_matrix.npz
|   |-- movie_df.pickle
|   |-- movie_scores.pickle
|   |-- tfidf_matrix.npz
|   |-- tmdb_5000_credits.csv
|   |-- tmdb_5000_movies.csv
|-- helper
|   |-- predict.py
|   |-- utils.py
|-- interface
|   |-- components.py
|-- notebooks
|   |-- recommendation_system.ipynb
|-- constants.py
|-- content.py
|-- README.md
|-- requirements.txt
|-- streamlit_app.py
|-- style.css
```

## Files Description

The project directory structure is organized as follows:

- **`__pycache__`**: This directory contains Python cache files generated by the interpreter.

- **`.streamlit`**: This directory contains Streamlit configuration files.

  - `config.toml`: Streamlit configuration file.

- **`assets`**: This directory contains additional assets for the project.

  - `social_components.html`: HTML file for social media sharing components.

- **`data`**: This directory stores data files used by the recommendation engine.

  - `count_matrix.npz`: Compressed NumPy matrix containing movie count data.
  
  - `movie_df.pickle`: Pickle file containing movie data.
  
  - `movie_scores.pickle`: Pickle file containing movie scores data.
  
  - `tfidf_matrix.npz`: Compressed NumPy matrix containing TF-IDF data.
  
  - `tmdb_5000_credits.csv`: CSV file containing movie credits data.
  
  - `tmdb_5000_movies.csv`: CSV file containing movie details data.

- **`helper`**: This directory contains Python helper scripts.

  - `predict.py`: Script for making movie recommendations.
  
  - `utils.py`: Utility functions used by the recommendation engine.

- **`interface`**: This directory contains Python scripts for the user interface.

  - `components.py`: User interface components for displaying movie recommendations.

- **`notebooks`**: This directory contains Jupyter notebooks.

  - `recommendation_system.ipynb`: Jupyter notebook with code and analysis for the recommendation system.

- `constants.py`: Python file containing project constants and configurations.

- `content.py`: Python script for content-based movie recommendations.

- `README.md`: This file, providing an overview of the project.

- `requirements.txt`: List of Python packages and dependencies required to run the project.

- `streamlit_app.py`: Main application script using Streamlit for the user interface.

- `style.css`: CSS file for styling the user interface.

## How to Run the Project Locally

To run the Movie Recommendation Engine project locally, follow these steps:

1. Clone the repository to your local machine:

```bash
git clone https://github.com/your-username/movie-recommendation-engine.git
``` 

2. Navigate to the project directory:

```bash
cd movie-recommendation-engine
```

3. Install the required Python packages and dependencies from the requirements.txt file:

 ```bash
pip install -r requirements.txt
```

4. Start the Streamlit application:

 ```bash
streamlit run streamlit_app.py
```
5. Open your web browser and access the application at http://localhost:8501.

You can now interact with the Movie Recommendation Engine and explore personalized movie recommendations based on different algorithms and data sources.

Enjoy discovering new movies and enhancing your movie-watching experience! 🤓
