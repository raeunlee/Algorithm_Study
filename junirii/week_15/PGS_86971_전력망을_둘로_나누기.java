class Solution {
    static int[][] link;
	static boolean[] visited;
	static int cnt, cnt_tmp;
    
    public int solution(int n, int[][] wires) {
       int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i < wires.length; i++) {
			cnt = 0;
			cnt_tmp = 0;
			link = new int[n+1][n+1];
			visited = new boolean[n+1];
			for (int j = 0; j < wires.length; j++) {
				if(i == j) continue;
				link[wires[j][0]][wires[j][1]] = 1;
				link[wires[j][1]][wires[j][0]] = 1;
			}
			dfs(1);
			cnt = cnt_tmp;
			cnt_tmp = 0;
			for (int j = 1; j < visited.length; j++) {
				if(visited[j] == false) dfs(j);
			}
			answer = Math.min(answer, Math.abs(cnt - cnt_tmp));
		}
		
		return answer;
    }
    
    static void dfs(int a) {
		visited[a] = true;
		cnt_tmp++;
		for (int i = 1; i < link.length; i++) {
			if(link[a][i] > 0 && visited[i] == false) {
				dfs(i);
			}
		}
	}
}
