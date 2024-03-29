
# def dfs(start, end, visited,l):
#     if start == end:
#         return
#     # visited.add(start)
#     for r in road[start] :
#         if r not in visited:
#             visited.add(r)
#             if r != s and r!= t:
#                 l.add(r)
#             dfs(r-1,end,visited, l)
            
# n, m = map(int, input().split())
# #배열 생성
# road = [[] for _ in range(n)]

# #자기 위치에서 갈수있는 곳 받기
# for i in range(m):
#     a, b = map(int, input().split())
#     road[a-1].append(b)

# s,t = map(int, input().split())

# # s -> t
# visited = set()
# l = set()
# dfs(s-1, t-1, visited, l)
# # print(l)

# # t -> s
# visited2 = set()
# l2 = set()
# dfs(t-1, s-1, visited2, l2)
# # print(l2)

# common = l & l2
# print(len(common))
import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
#배열 생성
road = [[] for _ in range(n+1)]
roadR = [[] for _ in range(n+1)]
#자기 위치에서 갈수있는 곳 받기
for i in range(m):
    a, b = map(int, input().split())
    road[a].append(b)
    roadR[b].append(a)
s,t = map(int, input().split())

def dfs(now, road, visit):
    if visit[now] == 1: #방문했다면
        return
    visit[now] = 1 #방문처리
    for neighbor in road[now]:
        dfs(neighbor, road, visit)
    return

# s에서 출발
fromS = [0] * (n+1)
fromS[t] = 1
dfs(s,road,fromS)

fromT = [0] * (n+1)
fromT[s] = 1
dfs(t,road,fromT)

toS = [0]*(n+1)
dfs(s,roadR,toS)

toT = [0]*(n+1)
dfs(t, roadR, toT)

count = 0
for i in range(1,n+1):
    if fromS[i] and fromT[i] and toS[i] and toT[i]:
        count += 1
print(count-2)