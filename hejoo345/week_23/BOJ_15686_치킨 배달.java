import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static int answer;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];

        backtracking(0, 0);
        System.out.println(answer);
    }

    public static void backtracking(int start, int depth) {
        if (depth == m) {
            int total = 0; // 도시의 치킨거리

            for (int i = 0; i < home.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (visited[j]) {
                        int dist = Math.abs(home.get(i).x - chicken.get(j).x)
                                + Math.abs(home.get(i).y - chicken.get(j).y);
                        temp = Math.min(temp, dist);
                    }
                }
                total += temp;
            }
            answer = Math.min(answer, total);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            backtracking(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}