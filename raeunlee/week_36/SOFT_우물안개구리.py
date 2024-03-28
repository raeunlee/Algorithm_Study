import sys
input = sys.stdin.readline
n, m = map(int, input().split())

#멤버들의 무게 
member = list(map(int, input().split()))
#최고라고 생각하는 배열 - 모두가 자기가 최고라고 가정한다
member2 = [True] * n

#친분관계
friend = []
for i in range(m):
    a, b = map(int, input().split())
    friend.append((a,b))


# i+1는 위치, 값은 W  
for f in friend:
    if member[f[0]-1] > member[f[1]-1]:
        member2[f[1]-1] = False
        
    elif member[f[0]-1] < member[f[1]-1]:
        member2[f[0]-1] = False 
    
    else: # 둘이 같을경우 - 둘다 False
        member2[f[0]-1] = False 
        member2[f[1]-1] = False

ans = 0
for m2 in member2:
    if m2 == True:
        ans+=1
print(ans)