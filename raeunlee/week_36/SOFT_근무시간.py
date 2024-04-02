import sys
h_sum = 0
m_sum = 0
for i in range(5):
    time = str(input())
    h = int(time[6:8]) - int(time[:2])
    m = int(time[9:11]) - int(time[3:5])
    
    if m < 0:
        h  -= 1
        m = int(time[9:11]) - int(time[3:5]) + 60
        # print(h,m)

    h_sum += h
    m_sum += m
print(h_sum*60 + m_sum)
    