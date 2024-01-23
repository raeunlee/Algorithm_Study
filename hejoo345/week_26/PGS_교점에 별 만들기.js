function solution(line) {
    let [maxX, minX, maxY, minY] = [-Infinity, Infinity, -Infinity, Infinity];
    let points = [];
    // 교점 찾아서 넣기
    for (let i = 0; i < line.length - 1; i++) {
        for (let j = i + 1; j < line.length; j++) {
            const denominator = line[i][0] * line[j][1] - line[i][1] * line[j][0];
            if (denominator !== 0) {
                const x = (line[i][1] * line[j][2] - line[i][2] * line[j][1]) / denominator;
                const y = (line[i][2] * line[j][0] - line[i][0] * line[j][2]) / denominator;
                // 정수일때만
                if (Number.isInteger(x) && Number.isInteger(y)) {
                    points.push([x, y]);
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                }
            }
        }
    }
    const answer = new Array(maxY - minY + 1)
        .fill()
        .map(() => new Array(maxX - minX + 1).fill("."));

    points.forEach(([x, y]) => {
        answer[maxY - y][x - minX] = "*";
    });

    return answer.map(str => str.join(""));
}