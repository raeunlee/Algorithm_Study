from collections import deque

def solution(priorities, location):
    answer = 1
    q = deque(priorities)
    idx = location
    while len(q) > 1:
        tmp = q.popleft()
        if tmp < max(q): #제일 큰 값보다 현재 프로세스가 작다면 
            q.append(tmp) # 뒤로 보낸다
            if idx==0: #찾아야할 index가 0이면 
                idx=len(q)-1 #index를 뒤로 보냈으니 수정해줌 
            else: #0이 아니면 -1을 해줌 
                idx-=1
        else: #현재 프로세스가 크거나 같다면
            if idx==0: #index가 0이면 
                return answer #값 리턴
            else:
                answer+=1 #0이 아니면 같은 숫자가 뒤에 있다는 것이니 +1을 해주고
                idx-=1 #인덱스도 줄여준다
                
    return answer