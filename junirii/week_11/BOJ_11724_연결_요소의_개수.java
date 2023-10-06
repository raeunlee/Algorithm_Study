import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b]++;
			arr[b][a]++;
		}
		
		int cnt = 0;
		for (int i = 1; i < arr.length; i++) {
			if(visited[i] == false) {
				check(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void check(int num) {
		visited[num] = true;
		for (int i = 1; i < arr[num].length; i++) {
			if(arr[num][i] > 0 && visited[i] == false) {
				check(i);
			}
		}
	}
}
