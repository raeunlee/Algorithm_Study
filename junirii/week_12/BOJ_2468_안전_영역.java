import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				int h = sc.nextInt();
				arr[i][j] = h;
				max = Math.max(max, h);
				min = Math.min(min, h);
			}
		}
		
		int answer_max = 0;
		for (int i = min-1; i <= max; i++) {
			visited = new boolean[N][N];
			int answer = 0;
			for (int j = 0; j < arr.length; j++) {
				for (int z = 0; z < arr[j].length; z++) {
					if(arr[j][z] > i && visited[j][z] == false) {
						dfs(j, z, i);
						answer++;
					}
				}
			}
			answer_max = Math.max(answer_max, answer);
		}
		System.out.println(answer_max);
	}
	
	static void dfs(int y, int x, int h) {
		visited[y][x] = true;
		for (int i = 0; i < 4.; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newX >= 0 && newY >= 0 && newX < N && newY < N && visited[newY][newX] == false && arr[newY][newX] > h) {
				dfs(newY, newX, h);
			}
		}
	}
}
