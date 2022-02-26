import math
 
B = int(input())
boxes = []
Children = []
for i in range(B):
    boxes.append(tuple(input().split()))
K = int(input()) 
 
for i in range(K):
    Children.append(tuple(input().split()))
 
def calcDist(child, boxes):
    distances = []
    childId, childX, childY = child[0], int(child[1]), int(child[2])
    for box in boxes:
        boxId, boxX, boxY = box[0], int(box[1]), int(box[2])
        distance = math.sqrt((boxX-childX)**2+(boxY-childY)**2)
        distances.append((boxId, distance))
    return distances
 
for child in Children:
    distances = calcDist(child, boxes)
    boxNear, distNear = min(distances, key=lambda x:x[1])
    print(child[0], boxNear)
 