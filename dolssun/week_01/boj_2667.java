package bj2667;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int town = 0;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]!=0 && !visited[i][j]) {
					int x = bfs(i,j);
					result.add(x);
					town++;
				}
			}
		}
		
		System.out.println(town);
		Collections.sort(result);
		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int k=0; k<4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(arr[nx][ny]!=0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						cnt += 1;
						q.add(new int[] {nx,ny});
					}
				}
			}
		}
		return cnt;
	}
}
