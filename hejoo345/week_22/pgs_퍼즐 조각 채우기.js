function solution(game_board, table) {
    let answer = 0;
    let blanks = []; // 빈칸 모양들 저장 배열
    let blocks = []; // 블록 모양들 저장 배열
    for (let i = 0; i < game_board.length; i++) {
        for (let j = 0; j < game_board.length; j++) {
            if (game_board[i][j] === 0) {
                game_board[i][j] = 1;
                blanks.push(bfs([[i, j]], game_board, 1));
            }
        }
    }
    for (let i = 0; i < table.length; i++) {
        for (let j = 0; j < table.length; j++) {
            if (table[i][j] === 1) {
                table[i][j] = 0;
                blocks.push(bfs([[i, j]], table, 0));
            }
        }
    }

    blocks.forEach(val => {
        for (let i = 0; i < blanks.length; i++) {
            let match = false;
            for (let j = 0; j < 4; j++) {
                val = rotate(val);
                if (JSON.stringify(val) === JSON.stringify(blanks[i])) {
                    blanks.splice(i, 1);
                    answer += val.length;
                    match = true;
                    break;
                }
            }
            if (match) break;
        }
    })
    return answer;
}

function bfs(start, table, k) {
    // k는 game_board에서는 0, table에서는 1로된 블럭의 좌표
    const dx = [0, 0, 1, -1];
    const dy = [1, -1, 0, 0];
    let needVisit = start; // [[x, y]] 형태
    let block = [];

    while (needVisit.length > 0) {
        let [curX, curY] = needVisit.shift(); // 현재좌표 꺼내기
        block.push([curX, curY]);
        //table[curX][curY] = k; // 재방문 방지

        for (let i = 0; i < 4; i++) {
            let nextX = curX + dx[i];
            let nextY = curY + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= table.length || nextY >= table.length) {
                continue;
            } else if (table[nextX][nextY] === k) { // 새 좌표의 칸이 원하는 칸이 아닐 때
                continue;
            } else { // 원하는 칸일때
                needVisit.push([nextX, nextY]);
                table[nextX][nextY] = k;
            }
        }
    }
    return moveBlock(block);
}

function moveBlock(block) {
    let minX = Math.min(...block.map(v => v[0]));
    let minY = Math.min(...block.map(v => v[1]));

    return block.map(v => [v[0] - minX, v[1] - minY]).sort();
}

function rotate(block) {
    let max = Math.max(...block.map(v => Math.max(v[0], v[1])));
    let rotateBlock = block.map(v => [max - v[1], v[0]]);

    return moveBlock(rotateBlock);
}