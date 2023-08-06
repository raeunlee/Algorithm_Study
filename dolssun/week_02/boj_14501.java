package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		int[] t = new int[n];
		int[] p = new int[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n; i++) {
			if(i+t[i]<=n) {
				dp[t[i]+i] = Math.max(dp[t[i]+i], p[i]+dp[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
			
		}
		System.out.println(dp[n]);
	}
}
