num=10
#x=1
primeList=[]
notPrimeList=[]
for x in range(2,num):
#while x<=20:
    if x%2==0:
        primeList.append(x)
    else:
        notPrimeList.append(x)
   # x+=1
print("The prime Numbers List is : ",primeList)
print("The list of Not Prime Numbers : ", notPrimeList)