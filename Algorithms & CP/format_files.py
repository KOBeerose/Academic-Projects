import os

def format_files(folder):
    for path, directory, files in os.walk(folder):
        for file in files:
            name = file.replace(" ", "_").lower()
            os.rename(os.path.join(path, file), os.path.join(path,name))

format_files("Academic-Projects/Algorithms & CP/NeetCode/") 