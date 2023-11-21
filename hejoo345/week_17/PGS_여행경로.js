function solution(tickets) {
    let answer = []; // 여행경로 배열
    const len = tickets.length + 1; // 총 여행경로 길이
    const visited = Array.from({length: tickets.length}, () => 0); // 사용한 항공권 표기

    function dfs(path) {
        if (path.length == len) {
            answer.push(path);
        } else {
            for (const i in tickets) {
                if (visited[i] == 0) { // 사용하지 않은 티켓
                    const [start, end] = tickets[i];
                    if (path[path.length - 1] == start) {
                        visited[i] = 1;
                        dfs([...path, end]);
                        visited[i] = 0;
                    }
                }
            }
        }
    }

    dfs(["ICN"]);

    // console.log(answer);
    return answer.sort()[0];
}
