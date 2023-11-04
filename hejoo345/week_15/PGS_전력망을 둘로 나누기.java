import java.util.*;

class Solution {
    static int[][] arr;

    public int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 전선을 하나씩 끊어봄
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            // 전선 끊기
            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            // 전선 다시 복구
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        return answer;
    }

    public int bfs(int n, int node) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && arr[now][i] == 1) {
                    queue.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs(n - cnt * 2);
    }
}