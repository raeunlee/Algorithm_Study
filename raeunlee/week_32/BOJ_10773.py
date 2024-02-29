# 백준 제로 
from collections import deque

k = int(input())
q = deque()
for i in range(k):
    x = int(input())
    if x == 0:
        q.pop()
    else:
        q.append(x)

print(sum(q))