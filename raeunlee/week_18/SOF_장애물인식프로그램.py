n = int(input())

block = []

for i in range(n):
  block.append(list(map(int, input())))
def dfs(x,y):
  if x < 0 or x >= n or y < 0 or y >= n:
    return False    
  if block[x][y] == 1:  
    cnt.append(1)
    block[x][y] = 0
    dfs(x+1,y)
    dfs(x-1,y)    
    dfs(x,y+1)
    dfs(x,y-1)
    return True
  return False

result = 0
cnt_list = []
cnt = []

for i in range(n):
  for j in range(n):
    if dfs(i,j) == True:
      result += 1
      cnt_list.append(len(cnt))
      cnt = [] #초기화 

print(result)
cnt_list.sort()
cnt.sort()
for i in cnt_list:
  print(i)
      
  
    
