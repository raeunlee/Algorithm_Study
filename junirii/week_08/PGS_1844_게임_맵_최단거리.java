import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int n, m;
    public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, 1, -1, 0};
	public static boolean[][] visited;
	public static int answer = -1;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }
    
    public int bfs(int x, int y, int[][] maps) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[]{x, y, 1});
        visited[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		int[] arr = q.poll();
    		int oldX = arr[0];
    		int oldY = arr[1];
    		int cnt = arr[2];
            
    		if(oldX == n-1 && oldY == m-1) {
    			answer = cnt;
                break;
    		}
    		
    		for (int i = 0; i < 4; i++) {
    			int newX = oldX+dx[i]; 
    			int newY = oldY+dy[i]; 
    			if(newX < 0 || newX > n-1 || newY < 0 || newY > m-1 || maps[newX][newY] == 0 || visited[newX][newY] == true) {
    				continue;
    			}
                visited[newX][newY] = true;
    			q.add(new int[] {newX, newY, cnt+1});
    		}
    	}
    	
    	return answer;
    }
}
