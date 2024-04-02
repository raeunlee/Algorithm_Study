import sys
n = int(input())
l = list(map(int, input().split()))

min_dis = 1e15
for i in range(n-1):
    min_dis = min(l[i+1] - l[i], min_dis)
#print(min_dis) # 최소 거리

cnt = 0
for i in range(n-1):
    if (l[i+1] - l[i] == min_dis):
        cnt += 1
print(cnt)
    
