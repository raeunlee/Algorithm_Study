import sys
num_0 = [1, 0]
num_1 = [0, 1]

def fibonacci(n):
    global num_0, num_1
    if n == 0 or n == 1:
        return num_0[n], num_1[n]
    else:
        for i in range(len(num_0), n+1):
            num_0.insert(i, num_0[i-2] + num_0[i-1])
            num_1.insert(i, num_1[i-2] + num_1[i-1])
        return num_0[n], num_1[n]

T = int(sys.stdin.readline())

for _ in range(T):
    N = int(sys.stdin.readline())
    a, b = fibonacci(N)
    print(a, b)

