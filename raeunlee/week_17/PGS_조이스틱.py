def solution(name):
    # 알파벳 변경
    up_down = 0
    # 커서 이동, 이름의 길이 - 1
    left_right = len(name) - 1  
    
    for i, updown in enumerate(name):
    	# 알파벳 변경 횟수, 위아래 중 최소 이동
        up_down += min(ord(updown) - ord('A'), ord('Z') - ord(updown) + 1)
        
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
            
        left_right = min([ left_right, 2 * i + len(name) - next, i + 2 * (len(name) - next) ])
        
        
   
    return up_down + left_right