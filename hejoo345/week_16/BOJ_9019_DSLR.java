import java.io.*;
import java.util.*;

public class Main {
    static String[] command;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            command = new String[10000];
            visited = new boolean[10000];
            Arrays.fill(command, "");

            Queue<Integer> q = new LinkedList<>();
            q.add(a);
            visited[a] = true;

            while (!q.isEmpty() && !visited[b]) {
                int n = q.poll();
                int D = n * 2 % 10000;
                int S = n == 0 ? 9999 : n - 1;
                int L = (n % 1000 * 10) + (n / 1000);
                int R = (n % 10 * 1000) + (n / 10);

                if (!visited[D]) {
                    q.add(D);
                    visited[D] = true;
                    command[D] = command[n] + "D";
                }
                if (!visited[S]) {
                    q.add(S);
                    visited[S] = true;
                    command[S] = command[n] + "S";
                }
                if (!visited[L]) {
                    q.add(L);
                    visited[L] = true;
                    command[L] = command[n] + "L";
                }
                if (!visited[R]) {
                    q.add(R);
                    visited[R] = true;
                    command[R] = command[n] + "R";
                }
            }
            System.out.println(command[b]);
        }
    }
}