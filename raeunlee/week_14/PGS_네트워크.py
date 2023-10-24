from collections import deque

def solution(n,computers):
    answer = 0
    visited = [False for _ in range(n)]
    for i in range(n):
        if visited[i] == False:
            visited[i]=True
            q = deque([i])
            answer += 1
        while q:
            idx = q.popleft()
            visited[idx]=True
            for j in range(n):
                if visited[j] == False and computers[idx][j] == 1:
                    q.append(j)
    return answer