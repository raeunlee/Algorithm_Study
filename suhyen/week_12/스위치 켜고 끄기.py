import sys
input = sys.stdin.readline

switch_num = int(input())
switch_list = list(map(int, input().split()))

def male_switch(n) :
    tmp = n
    while tmp <= switch_num :
        switch_list[tmp-1] = 1 - switch_list[tmp-1]
        tmp += n
        
def female_switch(n) :
    tmp = 1
    while n - tmp >= 1 and n + tmp <= switch_num :
        if switch_list[n-tmp-1] == switch_list[n+tmp-1] :
            tmp += 1
            continue
        break
    
    switch_list[n-1] = 1 - switch_list[n-1]
    for i in range(1, tmp) :
        switch_list[n-i-1] = 1 - switch_list[n-i-1]
        switch_list[n+i-1] = 1 - switch_list[n+i-1]
        
def solve() :
    for _ in range(int(input())) :
        sx, num = map(int, input().split())
        if sx == 1 :
            male_switch(num)
        else :
            female_switch(num)

    idx = 0
    while idx <= switch_num :
        print(*(switch_list[idx:idx+10] if idx+10 <= switch_num else switch_list[idx:]))
        idx += 10
    
solve()