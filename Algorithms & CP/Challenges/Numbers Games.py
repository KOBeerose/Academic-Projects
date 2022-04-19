d = int(input())
for _ in range(int(input())):
    x,y = list(map(int, input().split(' ')))
    print(max(abs(x-d), abs(y-d))+1)