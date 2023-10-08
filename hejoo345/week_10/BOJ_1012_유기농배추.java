import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int m, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로 길이
            n = Integer.parseInt(st.nextToken()); // 세로 길이
            k = Integer.parseInt(st.nextToken()); // 배추 개수

            visited = new boolean[n][m];


            arr = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 열
                int y = Integer.parseInt(st.nextToken()); // 행
                arr[y][x] = 1;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        if(dfs(i, j)){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    static boolean dfs(int y, int x) {
        if (visited[y][x]) {
            return false;
        }
        visited[y][x] = true;
        for (int k = 0; k < 4; k++) {
            int nextY = y + dy[k];
            int nextX = x + dx[k];
            if (nextX >= 0 && nextY >= 0 && nextX < m && nextY < n) {
                if(arr[nextY][nextX] == 1){
                    dfs(nextY, nextX);
                }
            }
        }
        return true;
    }
}
