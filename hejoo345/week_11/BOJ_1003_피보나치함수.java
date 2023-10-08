import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int dp[][];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        dp = new int[41][2];
        dp[0][0] = 1; // n이 0일 때 0 호출
        dp[0][1] = 0; // n이 0일 때 1 호출
        dp[1][0] = 0; // n이 1일 때 0 호출
        dp[1][1] = 1; // n이 0일 때 1 호출

        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static int[] fibonacci(int n) {
        if(dp[n][0] == 0 && dp[n][1] == 0) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }
}