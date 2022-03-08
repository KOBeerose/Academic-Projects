import  datetime
a = int(input())
b = int(input())
begin_time = datetime.datetime.now()
pgcd = 1

for i in range (1,(min(a,b)+1)):
    if a%i == 0 and b%i == 0:
        pgcd = i 

print(datetime.datetime.now() - begin_time)
print(pgcd)
