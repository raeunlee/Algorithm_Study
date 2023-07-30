import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static int[][] arr;
	private static int[] numArr, result, result2;
	private static boolean[] visited;
	private static int n;
	private static ArrayList<Integer> answerList = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
		numArr = new int[n+1];
		visited = new boolean[n+1];
		result = new int[n/2+1];
		result2 = new int[n/2+1];
		for (int i = 1; i <= n; i++) {
			numArr[i] = i;
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		comb(1, 1);
		Collections.sort(answerList);
		System.out.println(answerList.get(0));
	}
	
	public static void comb(int depth, int start) {
		if(depth > n/2) {
			getScore(result);
			int idx = 1;
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n/2; j++) {
					if(result[j] == i) cnt++;
				}
				if(cnt == 0) result2[idx++] = i;
			}
			answerList.add(Math.abs(getScore(result) - getScore(result2)));
			return;
		}
		
		for (int i = start; i <= n; i++) {
			if(!visited[i]) {
				result[depth] = numArr[i];
				visited[i] = true;
				comb(depth+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static int getScore(int[] result) {
		int score = 0;
		for (int i = 1; i <= n/2; i++) {
			for (int j = i+1; j <= n/2; j++) {
				int a = result[i];
				int b = result[j];
				score += arr[a][b] + arr[b][a];
			}
		}
		return score;
	}
}
