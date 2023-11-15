def solution(prices):
    #모든 가격을 max값으로 세팅해준다
    answer = [i for i in range(len(prices) -1, -1, -1)] 
    stack = [0]  
    #값이 떨어지는 시점을 찾아 수정해준다    
    for i in range(1, len(prices)):
        while stack and prices[stack[-1]] > prices[i]:
            tmp = stack.pop() #pop 
            answer[tmp] = i - tmp
        stack.append(i)
    
    return answer