import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 국가의 수
        int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가
        int[][] arr = new int[n][4];
        int idx = 0; // k국가가 있는 위치
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
            arr[t][2] = Integer.parseInt(st.nextToken());
            arr[t][3] = Integer.parseInt(st.nextToken());
            if (arr[t][0] == k) idx = t;
        }
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            if (arr[idx][1] < arr[i][1]) {
                rank++;
            } else if (arr[idx][1] == arr[i][1] && arr[idx][2] < arr[i][2]) {
                rank++;
            } else if (arr[idx][1] == arr[i][1] && arr[idx][2] == arr[i][2] && arr[idx][3] < arr[i][3]) {
                rank++;
            }
        }
        System.out.println(rank + 1);
    }
}