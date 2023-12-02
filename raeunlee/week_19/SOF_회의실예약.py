n, m = map(int,input().split()) 
rooms = {}

for _ in range(n):
    room = input() # 회의실 이름
    rooms[room] = [0]*18+[1]   # 예약시간 초기화
    
for i in range(m):
    r, s, t = input().split() # 회의실이름, 시작시각, 종료시각 입력
    s = int(s)
    t = int(t)
    for i in range(s,t):
        rooms[r][i] = 1 # 예약된 것은 모두 1로 바꾼다

# 회의실 이름 오름차순으로 정렬
rooms = dict(sorted(rooms.items()))

for idx, room in enumerate(rooms):
  print(f'Room {room}:')
  times = []
  state = 1 #직전
  
  for i in range(9, 19):
    if state == 1 and rooms[room][i] == 0: 
      start = i
      state = 0 
    elif state == 0 and rooms[room][i] == 1:
      end = i
      state = 1
      times.append([start,end])

  if len(times) == 0:
    print('Not available')
  else:
    print(f'{len(times)} available:')
    for x in times:
        print(f'{x[0]:02d}-{x[1]}')
    
  # 구분선
  if idx != len(rooms)-1:
      print('-----')
