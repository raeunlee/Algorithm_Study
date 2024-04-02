
def solution(n):
    answer = 0
    origin = list(bin(n))
    origin_cnt = 0 # 1의 개수
    print(list(origin))
    for o in origin:
        if o == '1':
            origin_cnt += 1
    print(origin_cnt)
    
    for i in range(n+1, n + 17):
        # print(i)
        now = list(bin(i))
        now_cnt = 0
        for n in now:
            if n == '1':
                now_cnt += 1
        if origin_cnt == now_cnt:
            answer = i
            break

    return answer