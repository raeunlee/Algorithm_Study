class Solution {
    static int n;
    static int[][] computers;
    static boolean[] visited;

    public int solution(int cn, int[][] ccomputers) {
        n = cn;
        computers = ccomputers;
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }
        return answer;
    }

    public void dfs(int node) {
        if (visited[node]) return;

        visited[node] = true;
        for (int i = 0; i < n; i++) {
            if (computers[node][i] == 1) {
                dfs(i);
            }
        }
    }
}