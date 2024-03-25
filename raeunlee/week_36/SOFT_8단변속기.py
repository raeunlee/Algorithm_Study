
li = list(map(int, input().split()))
li2 = sorted(li)
li3 = sorted(li, reverse=True)

cnt_asc = 0
cnt_dec = 0

for i in range(8):
    if li[i] == li2[i]:
        cnt_asc += 1
    elif li[i] == li3[i]:
        cnt_dec += 1

if cnt_asc == 8:
    print("ascending")
elif cnt_dec == 8:
    print("descending")
else:
    print("mixed")

    