import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, 1, -1, 0};
	static int Y, X, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		X = sc.nextInt();
		int n = sc.nextInt();
		arr = new int[Y][X];
		visited = new boolean[Y][X];
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt()-1;
			int y2 = sc.nextInt()-1;
			for (int j = y1; j <= y2; j++) {
				for (int z = x1; z <= x2; z++) {
					arr[j][z] = 1;
				}
			}
		}
		
		int num = 0;
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == 0 && visited[i][j] == false) {
					answer = 0;
					dfs(i, j);
					l.add(answer);
					num++;
				}
			}
		}
		
		System.out.println(num);
		Collections.sort(l);
		for (Integer i : l) {
			System.out.print(i+" ");
		}
	}
	
	static void dfs(int y, int x) {
		visited[y][x] = true;
		answer++;
		for (int i = 0; i < 4; i++) {
			int newX = x+dx[i];
			int newY = y+dy[i];
			if(newY >= 0 && newY < Y && newX >= 0 && newX < X && visited[newY][newX] == false && arr[newY][newX] == 0) {
				dfs(newY, newX);
			}
		}
	}
}
