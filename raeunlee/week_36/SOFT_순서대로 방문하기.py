def dfs(x, y, destidx):
    global cnt
    if x == dest[destidx][0] and y == dest[destidx][1]:
        if destidx == m-1:
            cnt += 1
            return
        else:
            destidx += 1
    visit[x][y] = True
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < n and 0 <= ny < n and not visit[nx][ny] and arr[nx][ny] == 0:
            dfs(nx, ny, destidx)
    visit[x][y] = False

n, m = map(int, input().split())
arr = []
for i in range(n):
    row = list(map(int, input().split()))
    arr.append(row)
dest = []
visit = [[False for _ in range(n)] for _ in range(n)]  # 방문 배열 추가
for i in range(m):
    a, b = map(int, input().split())
    dest.append([a-1, b-1])

cnt = 0
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
dfs(dest[0][0], dest[0][1], 0)
print(cnt)

