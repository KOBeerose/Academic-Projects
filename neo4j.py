# import the neo4j driver for Python

from neo4j import GraphDatabase

 

# Database Credentials

uri             = "bolt://localhost:7687"

userName        = "neo4j"

password        = "test"

 

# Connect to the neo4j database server

graphDB_Driver  = GraphDatabase.driver(uri, auth=(userName, password))

 