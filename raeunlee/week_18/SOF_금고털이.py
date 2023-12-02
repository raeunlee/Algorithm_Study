
# 배당 무게 w, 귀금속 종류 n
w, n = map(int, input().split())
tmp = []

for i in range(n):
    tmp.append(list(map(int, input().split())))

#더 큰거 순서대로 정렬
tmp.sort(key = lambda x: x[1], reverse=True)

price = 0

for i in range(n):
    if w >= tmp[i][0]:
        w -= tmp[i][0]
        price += tmp[i][0] * tmp[i][1]
    else:
        price += w * tmp[i][1]
        break

print(price)