
def dfs(tickets, path):
    if not tickets:  # 티켓이 없으면 
        return path # 경로 반환
    current = path[-1] # 가장 최근 경로
    for i, ticket in enumerate(tickets):
        if current == ticket[0]: #가장 최근 경로가 그 다음 티켓의 출발지와 같으면
            next_tickets = tickets[:i] + tickets[i+1:]  # 사용한 티켓을 제외한 리스트
            next_path = dfs(next_tickets, path + [ticket[1]])
            if next_path: #다음 경로가 유효하면 
                return next_path #해당 경로 반환하고 종료

def solution(tickets):
    tickets.sort()  # 알파벳 순서로 정렬
    answer = dfs(tickets, ["ICN"]) #처음 찾아야 할 곳
    return answer