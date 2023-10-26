import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[50][2];
        for (int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());
            arr[t][0] = Integer.parseInt(st.nextToken());
            arr[t][1] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
            }
            sb.append(cnt+1).append(" ");
        }
        System.out.println(sb);
    }
}