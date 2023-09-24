class Solution {
    static boolean[] visited;
	static int maxCnt;
    
    public int solution(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
        	visited = new boolean[dungeons.length];
        	if(k >= dungeons[i][1]) {
        		dfs(i, dungeons, k-dungeons[i][1], 1);
        	}
		}
        
        return maxCnt;
    }
    
    public void dfs(int idx, int[][] dungeons, int remain, int cnt) {
		visited[idx] = true;
		
		boolean isEnd = true;
		for (int i = 0; i < dungeons.length; i++) {
			if(visited[i] == false && dungeons[i][0] <= remain) {
				isEnd = false;
				dfs(i, dungeons, remain-dungeons[i][1], cnt+1);
			}
		}
		visited[idx] = false;
		
		if(isEnd) {
			maxCnt = Math.max(maxCnt, cnt);
		}
	}
}
