import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static boolean[][] visited;
	private static int[] dx = {-1, 0, 0, 1};
	private static int[] dy = {0, 1, -1, 0};
	private static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j-1, j));
			}
		}
		bfs(1, 1);
		System.out.println(arr[N][M]);
	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] item = new int[] {x, y};
		q.add(item);
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int newX = now[0] + dx[i];
				int newY = now[1] + dy[i];
				if(newX > 0 && newY > 0 && newX <= N && newY <= M) {
					if(!visited[newX][newY] && arr[newX][newY] > 0) {
						int[] newItem = new int[] {newX, newY};
						q.add(newItem);
						visited[newX][newY] = true;
						arr[newX][newY] = arr[now[0]][now[1]] + 1;
					}
				}
			}
		}
	}
}
