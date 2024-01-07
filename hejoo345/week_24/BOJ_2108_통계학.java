import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        int cnt = 1;
        int max_cnt = 1;

        int mode = arr[0]; // 최빈값
        boolean ck = true;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt > max_cnt) {
                mode = arr[i];
                max_cnt = cnt;
                ck = true;
            } else if (cnt == max_cnt && ck) {
                mode = arr[i];
                ck = false;
            }
        }

        sb.append(Math.round(sum / n)).append("\n"); // 산술평균
        sb.append(arr[n / 2]).append("\n"); // 중앙값
        sb.append(mode).append("\n"); // 최빈값
        sb.append(arr[n - 1] - arr[0]).append("\n"); // 최댓값과 최솟값 차이
        System.out.println(sb);
    }
}