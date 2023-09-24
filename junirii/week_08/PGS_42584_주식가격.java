class Solution {
    public int[] solution(int[] prices) {
       int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
        	int cnt = 0;
			for (int j = i+1; j < prices.length; j++) {
				if(prices[j] >= prices[i]) {
					cnt++;
				}else {
					cnt++;
					break;
				}
			}
			answer[i] = cnt;
		}
        
        return answer;
    }
}
