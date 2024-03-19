t = int(input())
for i in range(t):
    n = int(input())
    tmp = n // 5
    tmp2 = n % 5
    ans = ''
    if n > 5:
        for i in range(tmp):
            ans += "++++ "
    elif n == 5:
        ans += "++++"
    for i in range(tmp2):
        ans += '|'
    print(ans)
        