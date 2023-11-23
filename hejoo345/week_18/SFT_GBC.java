import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] speed = new int[101];
        int[] test = new int[101];

        int idx = 1;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int j = idx; j < idx + a; j++) {
                speed[j] = b;
            }
            idx += a;
        }

        idx = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            for (int j = idx; j < idx + a; j++) {
                test[j] = b;
            }
            idx += a;
        }

        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            answer = Math.max(answer, test[i] - speed[i]);
        }

        System.out.println(answer);
    }
}