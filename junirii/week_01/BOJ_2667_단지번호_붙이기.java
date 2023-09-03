import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int[][] arr;
	private static boolean visited[][];
	private static int[] dx = {-1, 0, 0, 1};
	private static int[] dy = {0, 1, -1, 0};
	private static int N, cnt, danji;
	private static ArrayList<Integer> resultList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					cnt = 1;
					bfs(i, j);
				}
			}
		}
		Collections.sort(resultList);
		System.out.println(danji);
		for (int i : resultList) {
			System.out.println(i);
		}
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] item = new int[] {i, j};
		q.add(item);
		visited[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for (int k = 0; k < 4; k++) {
				int newX = now[0] + dx[k];
				int newY = now[1] + dy[k];
				if(newX >= 0 && newX < N && newY >= 0 && newY < N) {
					if(!visited[newX][newY] && arr[newX][newY] == 1) {
						int[] newItem = new int[] {newX, newY};
						q.add(newItem);
						visited[newX][newY] = true;
						cnt++;
					}
				}
			}
		}
		resultList.add(cnt);
		danji++;
	}
}
