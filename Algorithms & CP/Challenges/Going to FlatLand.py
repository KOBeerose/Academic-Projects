for _ in range(int(input())):
    N, K = list(map(int,input().split(" ")))
    houses = list(map(int, input().split(" ")))
    houses = sorted(list(set(houses)))
    step = N//K
    result = [(houses[i:i+step][-1] - houses[i:i+step][0])/2 for i in range(0, len(houses), step)]
    print(format(max(result), '.3f'))