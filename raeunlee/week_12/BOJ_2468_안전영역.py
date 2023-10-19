from collections import deque

n = int(input())
graph = []
maxNum = 0
 
for i in range(n): #한 줄 씩 입력받기
    graph.append(list(map(int, input().split())))
    for j in range(n):
        if graph[i][j] > maxNum: #가장높은곳을 찾는것임
            maxNum = graph[i][j] 

# 상하좌우 이동
dx = [0 ,0, 1, -1]
dy = [1, -1, 0 ,0]   
       
def bfs(x, y, num, visited):
    q = deque()
    q.append((x,y))
    visited[x][y] = 1 
    while q:
        x, y = q.popleft()
        for i in range(4): #4방향으로 탐색
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < n:
                if graph[nx][ny] > num and visited[nx][ny] == 0: #최고 영역보다 높고 방문안했으면?
                    visited[nx][ny] = 1 #방문처리
                    q.append((nx, ny))
    
result = 0

for i in range(maxNum): #가장 높은 곳까지 반복하기 0부터! 
    visited = [[0] * n for i in range(n)] #방문check
    cnt = 0 #카운트 
    
    #이중 배열 돌기
    for j in range(n):
        for k in range(n): 
            if graph[j][k] > i and visited[j][k] == 0: # i보다 크고, 방문안했으면 방문시작
                bfs(j, k, i, visited)
                cnt+=1 #안전영역 카운트 
    
    if result < cnt: 
        result = cnt # 제일 큰 카운트 프린트
        
print(result)