# n = int(input())

# for _ in range(n):
#     row = int(input())
#     sticker = []
#     for _ in range(2):
#         sticker.append(list(map(int, input().split())))
    
#     now_col = -1 #현재 행
#     result = 0 # 출력 값 초기화
#     for i in range(row):
#         for j in range(row):
#             if sticker[0][i] + sticker[1][j] > sticker[1][i] + sticker[0][j]:
#                 if now_col == -1: #최초 값이면?
#                     if sticker[0][i]> sticker[1][j]: 
#                         result += sticker[0][i]
#                         print(result)
#                         now_col = 0
#                     else: 
#                         result += sticker[1][j]
#                         print(result)
#                         now_col = 1
#                 elif now_col == 0: #직전 행이 0이었다면?
#                     result += sticker[1][j]
#                     print(result)
#                     now_col = 1
#                 elif now_col == 1:
#                     result += sticker[0][i]
#                     print(result)
#                     now_col = 0
#             else: #반대 대각선이 더 클 경우
#                 if now_col == -1:
#                     if sticker[1][i] > sticker[0][j]:
#                         result += sticker[1][i]
#                         print(result)
#                         now_col = 1
#                     else:
#                         result += sticker[0][j]
#                         print(result)
#                         now_col = 0
#                 elif now_col == 0:
#                     result += sticker[1][i]
#                     print(result)
#                     now_col = 1
#                 elif now_col == 1:
#                     result += sticker[0][j]
#                     print(result)
#                     now_col = 0
#     print(result)
               
               
                
T = int(input())
for _ in range(T):
    n = int(input())
    dp = [list(map(int, input().split())) for _ in range(2)]

    if n == 1 :
        print(max(dp[0][0], dp[1][0]))
    else:
        
        dp[0][1] += dp[1][0]
        dp[1][1] += dp[0][0]

        for i in range(2,n):
            dp[0][i] += max(dp[1][i-1], dp[1][i-2])
            dp[1][i] += max(dp[0][i-1], dp[0][i-2])
            
        print(max(dp[0][n-1], dp[1][n-1]))