class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
		
		int start = 0;
		int max_idx = 0;
		for (int i = 0; i < number.length() - k; i++) {
			int max = 0;
			
			for (int j = start; j <= i+k; j++) {
				int cur = number.charAt(j) - '0';
				if(cur > max) {
					max = cur;
					max_idx = j;
				}
			}
			sb.append(max);
			start = max_idx + 1;
		}
		
		return sb.toString();
    }
}
