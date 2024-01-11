from sys import stdin
from sys import maxsize

N, M = map(int, stdin.readline().split())

INF = maxsize
graph = [[INF for i in range(N)] for j in range(N)]

for i in range(M):
    a, b = map(int, stdin.readline().split())
    graph[a - 1][b - 1] = 1
    graph[b - 1][a - 1] = 1

for i in range(N):
    graph[i][i] = 0
    
for k in range(N):
    for a in range(N):
        for b in range(N):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = 0
s = INF
for i, data in enumerate(graph):
    if sum(data) < s:
        s = sum(data)
        answer = i + 1
print(answer)