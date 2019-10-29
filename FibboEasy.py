from click._compat import raw_input
N=[]
D=[0,1]
E=[]

T=int(raw_input())

for i in range(T):
    N.append(int(raw_input()))

print(N)

for i in range(T):
    for j in range(2,N[i]):
        temp=D[j-1]+D[j-2]
        D.append(temp)
        
        D[j]=D[j]%10
        print(D)
        
        l=N[i]
        
        while(l>=1):
            for k,j in range(l):
                print(k)
                print(j)
                D[k]=D[j]
            l=l/2
        
    print(D[0])
