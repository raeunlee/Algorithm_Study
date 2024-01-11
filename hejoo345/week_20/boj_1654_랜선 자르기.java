import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        int[] arr = new int[k];
        long max = 0;
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = arr[i] > max ? arr[i] : max;
        }

        max++;
        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (max + min) / 2;
            long cnt = 0;
            for (int i = 0; i < k; i++) {
                cnt += arr[i] / mid;
            }
            if (cnt < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}