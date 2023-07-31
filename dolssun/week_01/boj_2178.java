package bj_2178;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n ;i++) {
			String input = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		bfs(0,0);
		
		System.out.println(arr[n-1][m-1]);
	}


	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(arr[nx][ny]!=0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						arr[nx][ny] = arr[now[0]][now[1]]+1;
						q.add(new int[] {nx,ny});
					}
				}
			}
			
			
		}
		
	}
}
