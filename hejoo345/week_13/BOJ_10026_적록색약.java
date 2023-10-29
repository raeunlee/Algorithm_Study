import java.io.*;

public class Main {
    static int n;
    static char[][] rgb;
    static char[][] rgb2; // 적록색약 배열
    static boolean[][] visit;
    static boolean[][] visit2; // 적록색약 방문배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt;
    static int cnt2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rgb = new char[n][n];
        rgb2 = new char[n][n];
        visit = new boolean[n][n];
        visit2 = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                rgb[i][j] = s.charAt(j);
                if (s.charAt(j) == 'G') {
                    rgb2[i][j] = 'R'; // 적록색약의 경우 G도 R로 배열에 추가
                } else {
                    rgb2[i][j] = s.charAt(j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, rgb[i][j]);
                    cnt++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit2[i][j]) {
                    dfs2(i, j, rgb2[i][j]);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt + " " + cnt2);
    }

    static void dfs(int x, int y, char c) {
        if (visit[x][y]) return;

        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (rgb[nextX][nextY] == c) {
                    dfs(nextX, nextY, c);
                }
            }
        }
    }

    static void dfs2(int x, int y, char c) {
        if (visit2[x][y]) return;

        visit2[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (rgb2[nextX][nextY] == c) {
                    dfs2(nextX, nextY, c);
                }
            }
        }
    }
}