import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] sizes) {
       int answer = 0;
	    
	    PriorityQueue<Integer> q_short = new PriorityQueue<Integer>(Collections.reverseOrder());
	    PriorityQueue<Integer> q_long = new PriorityQueue<Integer>(Collections.reverseOrder());
	    for (int i = 0; i < sizes.length; i++) {
	    	int s = Math.min(sizes[i][0], sizes[i][1]);
	    	int l = Math.max(sizes[i][0], sizes[i][1]);
	    	q_short.add(s);
	    	q_long.add(l);
		}
	    answer = q_short.poll() * q_long.poll();
	    
	    return answer;
    }
}
