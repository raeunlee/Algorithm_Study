import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
		
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < priorities.length; i++) {
			q.add(new int[] {i, priorities[i]});
		}
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int cnt = 0;
			for (int[] a : q) {
				if(arr[1] < a[1]) cnt++;
			}
			if(cnt > 0) {
				q.add(arr);
			}else {
				if(arr[0] == location) break;
				answer++;
			}
		}
		
		return answer;
    }
}
