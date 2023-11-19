function solution(triangle) {
    let dp = [triangle[0][0]];

    for (let i = 1; i < triangle.length; i++) {
        let tmp = [];
        for (let j = 0; j < i + 1; j++) {
            const left = Number(triangle[i][j]) + Number(dp[j - 1]);
            const right = Number(triangle[i][j]) + Number(dp[j]);
            if (j == 0) {
                tmp.push(right);
            } else if (j == i) {
                tmp.push(left);
            } else {
                let max = Math.max(left, right);
                tmp.push(max);
            }
        }
        dp = tmp;
    }
    return Math.max(...dp);
}