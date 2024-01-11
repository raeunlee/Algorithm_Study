import sys
input = sys.stdin.readline

n , k = map(int, input().split())
student = list(map(int, input().split()))
for _ in range(k):
  a, b = map(int, input().split())
  sum = 0
  cnt = 0 
  for i in range(a-1,b):
    sum += student[i]
  ans = sum/(b-a+1)
  
  print('{:.2f}'.format(round(ans,2)))
  