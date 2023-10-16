import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[101][101];
		for (int i = 0; i < N; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = x1+10;
			int y2 = y1+10;
			for (int j = y1; j < y2; j++) {
				for (int z = x1; z < x2; z++) {
					arr[j][z] = 1;
				}
			}
		}
		
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] > 0) answer++;
			}
		}
		System.out.println(answer);
	}
}
