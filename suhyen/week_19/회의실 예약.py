
import sys

N, M = map(int, sys.stdin.readline().split())
rooms = [] 
status = [[False for i in range(9)] for i in range(50)]

for i in range(N):
    rooms.append(input()) 
rooms.sort()

for i in range(M):
    r, s, e = input().split()
    s, e = int(s) - 9, int(e) - 9
    for j in range(s, e):
        status[rooms.index(r)][j] = True 

for i in range(N):
    print('Room %s:' % rooms[i])
    if False not in status[i]: 
        print('Not available')
    else:
        k = 0
        available = []
        while k < 9:
            f, t = 0, 0
            if not status[i][k]:
                f = k
                while k < 9 and not status[i][k]:
                    k += 1
                t = k - 1
                available.append([f, t]) 
            k += 1
        print(len(available), 'available:')
        for o in available:
            print('{}-{}'.format(format(o[0] + 9, '02'), format(o[1] + 10, '02')))
    if i != N - 1:
        print('-----')
