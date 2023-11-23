
N = int(input())
mac = [0] * 16
mac[0] = 2
for i in range(1, N+1):
  mac[i] = mac[i-1] + (2**(i-1))
  
print(mac[N]**2)