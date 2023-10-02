import java.util.Scanner;

public class Main {
	static int[] dx = {1, 0, 0, -1}; 
	static int[] dy = {0, 1, -1, 0};
	static int x, y, answer;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			answer = 0;
			x = sc.nextInt();
			y = sc.nextInt();
			int cnt = sc.nextInt();
			arr = new int[y][x];
			visited = new boolean[y][x];
			for (int j = 0; j < cnt; j++) {
				int worm_x = sc.nextInt();
				int worm_y = sc.nextInt();
				arr[worm_y][worm_x] = 1;
			}
			
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr[j].length; j2++) {
					if(arr[j][j2] == 1 && visited[j][j2] == false) {
						dfs(j, j2);
						answer++;
					}
				}
			}

			System.out.println(answer);
		}
	}
	
	static void dfs(int oy, int ox) {
		visited[oy][ox] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = ox + dx[i];
			int ny = oy + dy[i];
			if(nx >= 0 && nx < x && ny >= 0 && ny < y && arr[ny][nx] == 1) {
				if(arr[ny][nx] == 1 && visited[ny][nx] == false) {
					dfs(ny, nx);
				}
			}
		}
	}
}
