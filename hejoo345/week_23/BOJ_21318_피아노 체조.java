import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 악보의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i - 1] > arr[i]) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }
        int q = Integer.parseInt(br.readLine()); // 질문의 개수
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(sum[y] - sum[x]).append("\n");
        }
        System.out.println(sb.toString());
    }
}