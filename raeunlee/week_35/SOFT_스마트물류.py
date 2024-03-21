

n, k = map(int, input().split())

line = list(input().rstrip())
visited = [False] * n

for i in range(0, n):
    if line[i] == 'P': #로봇이면 
        for j in range(i-k, i+k+1):
            if (i==j) or (0>j) or (j>=n) : continue
            if line[j] == 'H' and not visited[j]: #가장 가까운 부품을 찾는다 (완전탐색)
                visited[j] = True
                break

count = 0
for result in visited:
    if result == True:
        count+=1

print(count)



