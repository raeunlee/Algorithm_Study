import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int wsum;
    static int bsum;
    static int wresult;
    static int bresult;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j] == 'W') {
                        wsum = 0;
                        wresult += dfs(i, j, 'W');
                    } else {
                        bsum = 0;
                        bresult += dfs(i, j, 'B');
                    }
                }
            }
        }
        System.out.println(wresult + " " + bresult);
    }

    public static int dfs(int y, int x, char soldier) {
        if (soldier == 'W') wsum++;
        else bsum++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (arr[nextY][nextX] == soldier && !visited[nextY][nextX]) {
                    dfs(nextY, nextX, soldier);
                }
            }
        }

        if (soldier == 'W') return wsum * wsum;
        return bsum * bsum;
    }
}