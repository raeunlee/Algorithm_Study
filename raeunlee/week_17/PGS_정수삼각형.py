def solution(triangle):
    
    for i in range(1, len(triangle)): # 둘째 줄부터 끝까지 
        for j in range(i+1):
            
            if j == 0: # 첫번째 수
                triangle[i][j] += triangle[i-1][j]
                
            elif j == i: # 마지막 수
                triangle[i][j] += triangle[i-1][j-1]
                
            else: # 그 전에꺼 대각선 방향중 더 큰것 더하기
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i - 1][j])
                
    return max(triangle[len(triangle)-1])