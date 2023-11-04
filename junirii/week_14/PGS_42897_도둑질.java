class Solution {
    public int solution(int[] money) {
        int n = money.length;
		
		// 첫번째 집 털었을 때
		int[] dp1 = new int[n];
		dp1[0] = money[0];
		dp1[1] = money[1];
		dp1[2] = money[0] + money[2];
		for (int i = 3; i < money.length-1; i++) {
			dp1[i] = Math.max(dp1[i-2], dp1[i-3]) + money[i];
		}
		
		// 첫번째 집 안털었을 때
		int[] dp2 = new int[n];
		dp2[1] = money[1];
		dp2[2] = money[2];
		dp2[3] = money[1] + money[3];
		for (int i = 4; i < money.length; i++) {
			dp2[i] = Math.max(dp2[i-2], dp2[i-3]) + money[i];
		}
        
		int dp1_max = Math.max(dp1[n-2], dp1[n-3]);
		int dp2_max = Math.max(dp2[n-1], dp2[n-2]);
		int answer = Math.max(dp1_max, dp2_max);
		return answer;
    }
}
