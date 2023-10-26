import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
		
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < costs.length; i++) {
			if(find(costs[i][0]) != find(costs[i][1])) {
				union(costs[i][0], costs[i][1]);
				answer += costs[i][2];
			}
		}
		
		return answer;
    }
    
    static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return find(parent[a]);
	}
	
	static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		if(p1 < p2) {
			parent[p2] = p1;
		}else {
			parent[p1] = p2;
		}
	}
}
