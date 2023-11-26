import java.io.*;
import java.util.*;

public class Main {
    static int[][] lights = {
            {1, 1, 1, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 1, 1},
            {1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 1, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] a_arr = new int[5];
            int[] b_arr = new int[5];
            Arrays.fill(a_arr, -1);
            Arrays.fill(b_arr, -1);

            for (int i = 0; i < 5; i++) {
                a_arr[i] = a % 10;
                a /= 10;
                if (a == 0) break;
            }
            for (int i = 0; i < 5; i++) {
                b_arr[i] = b % 10;
                b /= 10;
                if (b == 0) break;
            }
            int answer = 0;
            for (int i = 0; i < 5; i++) {
                int n = a_arr[i];
                int m = b_arr[i];
                //System.out.println(a_arr[i] +" "+b_arr[i]);
                if (n != m) {
                    if (n == -1) {
                        for (int j = 0; j < 7; j++) {
                            if (lights[m][j] == 1) {
                                answer++;
                            }
                        }
                    } else if (m == -1) {
                        for (int j = 0; j < 7; j++) {
                            if (lights[n][j] == 1) {
                                answer++;
                            }
                        }
                    } else {
                        for (int j = 0; j < 7; j++) {
                            if (lights[n][j] != lights[m][j]) {
                                answer++;
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
        }
    }
}