n = int(input())
l = list(map(int, input().split()))
sort_l = sorted(list(set(l))) # 중복제거, 오름차순 정렬

dic = {}

for i in range(len(sort_l)):
    dic[sort_l[i]] = i
    
for i in l: #딕셔너리에 있던 인덱스 값 출력하기
    print(dic[i], end=' ')  

