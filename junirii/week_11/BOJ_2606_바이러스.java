import java.util.Scanner;

public class Main {
	static int[][] relArr;
	static int[] answerArr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int rel = sc.nextInt();
		relArr = new int[N+1][N+1];
		answerArr = new int[N+1];

		for (int i = 0; i < rel; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			relArr[a][b]++;
			relArr[b][a]++;
		}

		check(1);
		int answer = 0;
		for (int i : answerArr) {
			if(i > 0) answer++;
		}
		System.out.println(answer);
	}
	
	static void check(int num) {
		for (int i = 2; i < relArr[num].length; i++) {
			if(relArr[num][i] > 0 && answerArr[i] == 0) {
				answerArr[i]++;
				check(i);
			}
		}
	}
}
