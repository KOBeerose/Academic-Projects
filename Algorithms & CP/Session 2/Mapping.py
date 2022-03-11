# dealing with input
keys = [line.strip() for line in open('Keys.txt')]
print(keys)

details = [list(line.strip().split(" ")) for line in open('Details.txt')]
print(details)

map = []
# mapping each key to the details
for i in range(len(keys)):
    for j in range(len(details)):
        if keys[i] in details[j]:
            map.append((i, j))

print(map)
