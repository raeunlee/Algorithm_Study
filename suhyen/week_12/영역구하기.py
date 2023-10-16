import sys
sys.setrecursionlimit(10000)

m,n,k = map(int,input().split())
graph = [[0]*n for i in range(m)]

rectangle = []
for i in range(k):
    rectangle.append(list(map(int,input().split())))

for point in rectangle:
    for x in range(point[0],point[2]):
        for y in range(point[1],point[3]):
            graph[y][x] = 1

d = [(-1, 0), (1, 0), (0, -1), (0, 1)]

def dfs(x,y,cnt):
    graph[x][y] = 1
    for dx,dy in d:
        X,Y = x+dx, y+dy
        if 0 <= X < m and 0 <= Y < n and graph[X][Y] == 0:
            cnt = dfs(X,Y,cnt+1)
    return cnt

res = []
for i in range(m):
    for j in range(n):
        if graph[i][j] == 0:
            res.append(dfs(i,j,1))

print(len(res))
print(*sorted(res))
    
print(result)