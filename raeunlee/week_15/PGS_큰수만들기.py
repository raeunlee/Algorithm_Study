def solution(number, k):
    answer = ''
    tmp = []
    for n in number:
        if len(tmp) == 0:
            tmp.append(n)
            continue
        if k>0:
            while tmp[-1] < n: #맨 위에가 n보다 작으면 
                tmp.pop() #쭉 팝
                k -= 1 
                if len(tmp) == 0 or k == 0:
                    break
        tmp.append(n)        
    if k > 0: 
        tmp = tmp[:-k] #맨 위에서부터 k까지의 요소만! (배열로 따지면 맨 뒤에서 k까지)
    else:
        tmp
    return ''.join(tmp)