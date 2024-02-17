import sys
sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

pre = []

while True:
    try:
        pre.append(int(input()))
    except:
        break

def post(start, end):
    
    if start>end:
        return
    mid = end + 1 #루트보다 큰 값이 없을 경우를 대비
    
    #루트 값을 기준으로 루트보다 큰 값이 존재하면 그 값을 기준으로 왼쪽, 오른쪽 트리를 나눠줌
    for i in range(start+1, end+1):
        if pre[i] > pre[start]:
            mid = i
            break
        
    #왼쪽 서브트리, 오른쪽 서브트리, 루트 순서로 출력
    post(start + 1, mid - 1)
    post(mid, end)
    print(pre[start])

post(0, len(pre) - 1)
    
