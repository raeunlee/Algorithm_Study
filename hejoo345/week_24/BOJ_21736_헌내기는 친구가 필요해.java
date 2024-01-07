import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int m;
    static String[][] arr;
    static boolean[][] visited;
    static int result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("I")) {
                    dfs(i, j);
                }
            }
        }

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if (arr[x][y].equals("P")) {
            result++;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (!visited[nextX][nextY] && !arr[nextX][nextY].equals("X")) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}