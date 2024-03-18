# 블로그2
import sys
input = sys.stdin.readline

n = int(input())
col = list(input().rstrip())
d = {'B': 0, 'R':0}
pre = ''
for c in col:
    if c != pre:
        d[c] += 1 # 전에꺼랑 다르면 +1
    pre = c
# 더 작은 색 + 배경색 카운트 
if d['B'] > d['R']:
    cnt = d['R'] + 1
else:
    cnt = d['B'] + 1
print(cnt)

# # print(col)
# background = 'B' #먼저 전체를 B로 칠했다고 가정한다
# count = 0
# for i in range(n):
#     now = col[i] #지금색상
#     if i == 0: # 맨처음이면
#         before = background
#     else: # 맨처음이 아니면
#         before = col[i-1] #직전의 색
#     if now != before and now != background: #현재색이 직전색과 다른데, 배경색과도 다르면 count += 1
#         count += 1
        
# print(count+1)