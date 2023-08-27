import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
       int answer = 0;
        
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
        	max = Math.max(max, citations[i]);
        }
        
        for (int i = 0; i <= max; i++) {
        	int cnt = 0;
        	int cnt_not = 0;
			for (int j = 0; j < citations.length; j++) {
				if(citations[j] >= i) cnt++;
				else if(citations[j] <= i) cnt_not++;
			}
			if(cnt >= i && cnt_not <= i) answer = Math.max(answer, i); 
		}
        
        return answer;
    }
}
