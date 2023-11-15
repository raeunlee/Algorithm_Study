function solution(begin, target, words) {
    var answer = 0;
    let queue = [];
    let visited = []

    if (!words.includes(target)) { // words에 target이 없으면 0 반환
        return 0;
    }

    queue.push([begin, answer]);
    visited.push(begin);

    while (queue) {
        const [word, cnt] = queue.shift();
        if (word == target) return cnt; // target과 일치하면 카운트 반환

        words.forEach(item => {
            let notEq = 0;
            if (visited.includes(item)) return; // forEach 종료
            for (let i = 0; i < item.length; i++) {
                if (word[i] != item[i]) {
                    notEq++;
                }
            }
            if (notEq == 1) {
                queue.push([item, cnt + 1]);
                visited.push(item);
            }
        })
    }
    return answer;
}