import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
       	int answer = 0;
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	for (int i: scoville) {
			pq.add(i);
		}
    	
    	while(true) {
    		if(pq.size() == 1) {
    			if(pq.poll() < 7) return -1;
    			else return answer;
    		}
    		int a = pq.poll();
    		if(a >= K) break;
    		int b = pq.poll();
    		int c = a + b*2;
    		if(pq.size() == 0) {
    			if(c < K) return -1;
    			else return answer+1;
    		}
    		pq.add(c);
    		answer++;
    	}
        return answer;
    }
}
