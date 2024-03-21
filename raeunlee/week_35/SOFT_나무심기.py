tmp = -10000

for i in range(n-1):
    for j in range(i+1, n):
        tmp = max(l[i]*l[j], tmp)
print(tmp)