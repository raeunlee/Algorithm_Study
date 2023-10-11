from collections import deque

n, m = map(int, input().split())
graph = [[]for i in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False]*(n+1)


def bfs(start):
    q = deque([start])
    while q:
        pop = q.popleft()
        visited[pop] = True # 방 문 처 리 
        for i in graph[pop]:
            if visited[i] == False:
                visited[i] = True
                q.append(i)
                
cnt = 0

for j in range(1, n+1):
    if visited[j] == False:
        bfs(j)
        cnt+=1
print(cnt)   
        
# def dfs(start):
#     visited[start] = True
#     for i in graph[start]:
#         if visited[i] == False:
#             dfs(i)
# cnt = 0
           
# for j in range(1, n+1): 
#     if visited[j] == False:
#         dfs(j)
#         cnt+=1

# print(cnt)

    