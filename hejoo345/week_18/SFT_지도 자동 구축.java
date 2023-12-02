import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[16][2];
        dp[0][0] = 2;
        dp[0][1] = 4;
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = dp[i][0] + (int) Math.pow(2, i);
            dp[i + 1][1] = (int) Math.pow(dp[i + 1][0], 2);
            // System.out.println(dp[i+1][0] +"  " +dp[i+1][1]);
        }
        System.out.println(dp[n][1]);
    }
}