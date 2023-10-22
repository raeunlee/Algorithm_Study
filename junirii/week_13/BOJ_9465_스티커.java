import java.util.Scanner;

public class Main {
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[2][n+1];
			int[][] dp = new int[2][n+1];
			for (int j = 0; j < 2; j++) {
				for (int j2 = 1; j2 <= n; j2++) {
					arr[j][j2] = sc.nextInt();
				}
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int j = 2; j <= n; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + arr[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + arr[1][j];
			}
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
	}
}
