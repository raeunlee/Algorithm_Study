package algoStudy.b1926;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int N, M, cnt, size, max;
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 0, 1};
	private static int[] dy = {0, 1, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				size = 0;
				bfs(i, j);
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	public static void bfs(int x, int y) {
		if(arr[x][y] == 0 || visited[x][y]) return;
		
		Queue<int[]> q = new LinkedList<int[]>();
		int[] item = {x, y}; 
		q.add(item);
		visited[x][y] = true;
		cnt++;
		size++;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
			for (int i = 0; i < 4; i++) {
				if(nx+dx[i] >= 0 && nx+dx[i] < N && ny+dy[i] >= 0 && ny+dy[i] < M) {
					if(arr[nx+dx[i]][ny+dy[i]] == 1 && !visited[nx+dx[i]][ny+dy[i]]) {
						int[] nitem = {nx+dx[i], ny+dy[i]};
						q.add(nitem);
						visited[nx+dx[i]][ny+dy[i]] = true;
						size++;
						max = Math.max(max, size);
					}
				}
			}
		}
	}
}
