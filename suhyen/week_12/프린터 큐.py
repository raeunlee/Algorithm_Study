test = int(input())
 
for _ in range(test):
    n, m = map(int, input().split())
    p = list(map(int, input().split()))
    index = [i for i in range(n)]
    index[m] = 1  
    cnt = 0
 
    while p:
        if p[0] == max(p):  
            cnt += 1
            if index[0] == 1:
                print(cnt)
                break
            p.pop(0)
            index.pop(0)
        else:
            p.append(p.pop(0))
            index.append(index.pop(0))
for i in range(max_height):
    count = 0
    visited = [[0]*n for _ in range(n)]
    for j in range(n):
        for k in range(n):
            if graph[j][k] > i and visited[j][k] == 0:
                bfs(j, k, i)
                count += 1
    result = max(result, count)
    
print(result)