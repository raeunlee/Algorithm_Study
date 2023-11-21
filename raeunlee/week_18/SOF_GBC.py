import sys
from collections import deque

n, m = map(int, input().split())
part_speed = [0] * 101
dis_sum = 0

for i in range(n): # n만큼 거리와 속도를 받아온다
    distance, speed = map(int, input().split())
    # 현재위치부터 입력받은 거리까지 스피드를 다 저장해준다 (매 칸마다 저장하는 것이다)
    for j in range(dis_sum, distance+dis_sum):
        part_speed[j+1] = speed
    #현재 위치 갱신해주면서 반복한다
    dis_sum += distance

dis_sum = 0
real = []
for i in range(m):
    # 거리랑 속도 받아온다
    distance, speed = map(int, input().split())
    # 현재 위치부터 받아온 거리까지 받아온 속도에서 미리 저장해둔 speed를 뺀다
    for j in range(dis_sum, distance + dis_sum):
        part_speed[j+1] = speed - part_speed[j+1]
    dis_sum += distance
# 100개의 구간에서 가장 큰 것을 출력해준다
print(max(part_speed))