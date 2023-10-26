import java.util.Scanner;

public class Main {
	static char[][] arr;
	static char[][] arr2;
	static boolean[][] visited;
	static boolean[][] visited2;
	static int N;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		arr = new char[N][N];
		arr2 = new char[N][N];
		visited = new boolean[N][N];
		visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String l = sc.nextLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = l.charAt(j);
				if(l.charAt(j) == 'R') {
					arr2[i][j] = 'G';
				}else {
					arr2[i][j] = l.charAt(j);
				}
			}
		}
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j] == false) {
					dfs(i, j);
					cnt++;
				}
				if(visited2[i][j] == false) {
					dfs2(i, j);
					cnt2++;
				}
			}
		}
		System.out.println(cnt + " " + cnt2);
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(newX >= 0 && newX < N && newY >= 0 && newY < N && visited[newY][newX] == false && arr[newY][newX] == arr[y][x]) {
				dfs(newY, newX);
			}
		}
	}
	
	static void dfs2(int y, int x) {
		visited2[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(newX >= 0 && newX < N && newY >= 0 && newY < N && visited2[newY][newX] == false && arr2[newY][newX] == arr2[y][x]) {
				dfs2(newY, newX);
			}
		}
	}
}
