# dealing with input
ids = []
details = []

n = int(input())
for i in range(n):
    ids.append(input())
ids.sort
print(ids)

m = int(input())
for j in range(m):
    details.append(input().split(','))
details.sort
print(details)

# mapping each key to the details
for x in ids:
    for i in range(m):
        if details[i][0] == x:
            print(','.join(details[i]))
