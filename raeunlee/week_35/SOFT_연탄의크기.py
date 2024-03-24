import sys
input = sys.stdin.readline

n = int(input())
zip = list(map(int, input().split()))

tmp = set()
for z in zip:
    for j in range(2,100):
        if z % j == 0:
            tmp.add(j)
            break
tmp = list(tmp)

max_cnt = 0
for i in range(len(tmp)):
    count = 0
    for z in zip:
        if z % tmp[i] == 0:
            count += 1
    max_cnt = max(max_cnt, count)
print(max_cnt)