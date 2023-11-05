import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
		PriorityQueue<Integer> q_rev = new PriorityQueue<>(Collections.reverseOrder());
		for (String s : operations) {
			if(s.startsWith("I")) {
				q.add(Integer.parseInt(s.substring(2)));
				q_rev.add(Integer.parseInt(s.substring(2)));
			}else if(s.equals("D 1")){
				q_rev.poll();
				if(q.size() == 1) q.poll();
			}else {
				q.poll();
				if(q_rev.size() == 1) q_rev.poll();
			}
		}
		
		int min = 0;
		int max = 0;
		while(!q.isEmpty()) {
			int i = q.poll();
			if(q_rev.contains(i)) {
				min = i;
				break;
			}
		}
		while(!q_rev.isEmpty()) {
			int i = q_rev.poll();
			if(q.contains(i)) {
				max = i;
				break;
			}
		}
		
		int[] answer = new int[] {max, min};
		return answer;
    }
}
