package bj_1926;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
		static int n,m;
		static int[][] arr;
		static boolean [][] visited;
		static int[] dx = {1,0,-1,0};	// 하, 좌, 상, 우
		static int[] dy = {0,-1,0,1};
		
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					max = Math.max(max, bfs(i,j));
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	public static int bfs(int i, int j) {
		
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {i,j});
		visited[i][j] = true;
		int size = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				
				if(x>=0 && y>=0 && x<n && y<m){
					if(arr[x][y]!=0 && !visited[x][y]) {
						size++;
						visited[x][y] = true;
						q.add(new int[] {x,y});
					}
				}
			}
		}
		return size;
	}
	
}
