package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, cnt;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visited;
	static int[] count = new int[25 * 25];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		Arrays.sort(count);
		System.out.println(cnt);
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				System.out.println(count[i]);
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		count[cnt]++;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++) {
				int nx = now[0] + dx[k];
				int ny = now[1] + dy[k];
				if (inRange(nx, ny) && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });
					count[cnt]++;
				}
			}

		}

	}

	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < n && ny < n;
	}

}
