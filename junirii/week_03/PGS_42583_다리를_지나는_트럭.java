import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int total_weight = 0;
		int idx = 1;
		int answer = 1;
		int[] sec_arr = new int[truck_weights.length];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, truck_weights[0]});
		total_weight += truck_weights[0];
		
		while(!q.isEmpty()) {
			// 다리 지난 트럭 제외
			int cnt = 0;
			for (int[] arr : q) {
				sec_arr[arr[0]]++;
				if(sec_arr[arr[0]] >= bridge_length) cnt++;
			}
			for (int i = 0; i < cnt; i++) {
				int[] arr = q.poll();
				total_weight -= arr[1];
			}
			
			// 새로운 트럭 진입
			if(idx < truck_weights.length) {
				int now_weight = truck_weights[idx];
				if(total_weight + now_weight <= weight) {
					total_weight += now_weight;
					q.add(new int[] {idx, now_weight});
					idx++;
				}
			}
			answer++;
		}
        return answer;
    }
	
	public static void main(String[] args) {
		int ans = solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10});
		System.out.println(ans);
	}
}
