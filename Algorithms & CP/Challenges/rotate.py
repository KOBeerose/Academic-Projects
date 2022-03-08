# dealing with inputs
n = int(input())
matrix = []
for i in range (n):matrix.append(input().split())
    
# pring results
for j in range(n) :
    for i in range(n - 1, -1, -1) :
        print(matrix[i][j], end = " ")
    print("")


