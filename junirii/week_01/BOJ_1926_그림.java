package baekjoon.b1926;

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
				if(!visited[i][j] && arr[i][j] == 1)
					bfs(i, j);
			}
		}
		
		System.out.println(cnt);
		System.out.println(max);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] item = new int[]{x, y}; 
		q.add(item);
		visited[x][y] = true;
		cnt++;
		size = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int newx = now[0] + dx[i];
				int newy = now[1] + dy[i];
				if(newx >= 0 && newx < N && newy >= 0 && newy < M) {
					if(arr[newx][newy] == 1 && !visited[newx][newy]) {
						int[] newItem = new int[]{newx, newy};
						q.add(newItem);
						visited[newx][newy] = true;
						size++;
					}
				}
			}
		}
		max = Math.max(max, size);
	}
}
