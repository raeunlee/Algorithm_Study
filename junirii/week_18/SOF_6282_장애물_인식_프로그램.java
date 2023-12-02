import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] dx = new int[] {-1, 0, 0, 1};
	static int[] dy = new int[] {0, -1, 1, 0};
	static boolean[][] visited;
	static int[][] arr;
	static int n, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.nextLine());
		arr = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String l = sc.nextLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(l.substring(j, j+1));
			}
		}
		
		List<Integer> l = new ArrayList<>();
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 1 && visited[i][j] == false) {
					dfs(i, j);
					l.add(answer);
					answer = 0;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(l);
		for (Integer i : l) {
			System.out.println(i);
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		answer++;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 1 && visited[nx][ny] == false) {
				dfs(nx, ny);
			}
		}
	}
}
