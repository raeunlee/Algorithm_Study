import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;
    static int max_cnt;
    static int max_height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max_height = arr[i][j] > max_height ? arr[i][j] : max_height;
            }
        }

        for (int h = 0; h <= max_height; h++) {
            cnt = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && arr[i][j] > h) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            max_cnt = Math.max(cnt, max_cnt);
        }
        System.out.println(max_cnt);
    }

    static void dfs(int x, int y, int height) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (!visit[nextX][nextY] && arr[nextX][nextY] > height) {
                    dfs(nextX, nextY, height);
                }
            }
        }
    }
}