function solution(m, n, puddles) {
    var answer = 0;
    let dp = Array.from({length: n}, () => Array(m).fill(0));

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (i === 0 && j === 0) {
                dp[0][0] = 1;
                continue;
            }
            // 물웅덩인지 확인
            if (puddles.some(puddle => (j + 1) === puddle[0] && (i + 1) === puddle[1])) continue;
            dp[i][j] = ((i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0)) % 1000000007;

        }
    }
    return dp[n - 1][m - 1];
}