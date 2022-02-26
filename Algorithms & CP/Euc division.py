a = str(input())
b = int(input())
position = r = 0
print(a)
for i in range (len(a)):
    
    num = r* 10 + int(a[position:i])
    if num < b:
        pass
    else:
        q = int(num/b)
        r = num - q*b
        position = i+1
print(str(a)+"/"+str(b)+" = "+str(q)+"*"+str(b)+" + "+str(r))
        

