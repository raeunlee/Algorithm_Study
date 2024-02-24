n = int(input())
balls = str(input())
cnt = []

#우측으로 레드모으기
r_r = balls.rstrip('R')
cnt.append(r_r.count('R'))
#우측으로 블루모으기
r_b = balls.rstrip('B')
cnt.append(r_b.count('B'))
#좌측으로 레드모으기
l_r = balls.lstrip('R')
cnt.append(l_r.count('R'))
#좌측으로 블루모으기
l_b = balls.lstrip('B')
cnt.append(l_b.count('B'))

print(min(cnt))

