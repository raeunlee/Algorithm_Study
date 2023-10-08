import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int arr[][];
    static boolean visited[];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        m = Integer.parseInt(st.nextToken()); // 간선의 개수

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[node][i] == 1) {
                dfs(i);
            }
        }
    }
}