package week03;

public class pgs_이진변환반복하기 {
	class Solution {
	    public int[] solution(String s) {
	        int[] answer = new int[2];
	        
	        while(s.length()>1){
	            int cnt = 0;
	            for(int i=0; i<s.length(); i++){
	                if(s.charAt(i)=='0')
	                    answer[1]++;
	                else
	                    cnt+=1;
	            }
	            
	            s = Integer.toBinaryString(cnt);
	            answer[0]+=1;
	        }
	        
	        return answer;
	    }
	}
}
