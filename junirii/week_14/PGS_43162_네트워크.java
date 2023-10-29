class Solution {
    static boolean[][] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
		visited = new boolean[n][n];
		
		for (int i = 0; i < computers.length; i++) {
			boolean is_alone = true;
			for (int j = 0; j < computers[i].length; j++) {
				if(i == j) continue;
				if(computers[i][j] == 0) continue;
				if(visited[i][j] == false && visited[j][i] == false) {
					dfs(i, j, computers);
					answer++;
				}
				is_alone = false;
			}
			if(is_alone) answer++;
		}
		
		return answer;
    }
    
    static void dfs(int a, int b, int[][] computers) {
		visited[a][b] = true;
		visited[b][a] = true;
		for (int i = 0; i < visited[b].length; i++) {
			if(i == b) continue;
			if(computers[b][i] == 0) continue;
			if(visited[b][i] == false && visited[i][b] == false) {
				dfs(b, i, computers);
			}
		}
	}
}
