import sys

m, n, k = map(int, input().split())
secret = list(map(int, input().split()))
button = list(map(int, input().split()))
count = 0
if len(button) < len(secret):
    count = 0
else:
    for i in range(len(button)-len(secret)+1):
        tmp = button[i:i+len(secret)]
        if tmp == secret:
            count += 1
if count > 0:
    print("secret")
else:
    print("normal")

            
        