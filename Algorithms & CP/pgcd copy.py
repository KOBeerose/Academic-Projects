import  datetime
from math import sqrt

a = int(input())
b = int(input())
begin_time = datetime.datetime.now()
pgcd = []

for i in range (2,(sqrt(a))):
    if a%i == 0 and b%i == 0:
        pgcd.append([i,a//i])

print(datetime.datetime.now() - begin_time)
print(max(pgcd))
