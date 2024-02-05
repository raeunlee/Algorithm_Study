import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r, c;
    static char[][] arr;
    static boolean[][] visited;
    static int ocnt;
    static int vcnt;
    static int oreuslt;
    static int vresult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        arr = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] != '#' && !visited[i][j]) {
                    ocnt = 0;
                    vcnt = 0;
                    dfs(i, j);
                    if (ocnt > vcnt) { // 양이 더 많으면
                        oreuslt += ocnt;
                    } else {
                        vresult += vcnt;
                    }
                }
            }
        }
        System.out.println(oreuslt + " " + vresult);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        if (arr[y][x] == 'o') {
            ocnt++;
        } else if (arr[y][x] == 'v') {
            vcnt++;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextY >= 0 && nextY < r && nextX >= 0 && nextX < c) {
                if (!visited[nextY][nextX] && arr[nextY][nextX] != '#') {
                    dfs(nextY, nextX);
                }
            }
        }
    }
}