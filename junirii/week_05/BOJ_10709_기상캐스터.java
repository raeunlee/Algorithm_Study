import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] answer = new int[H][W];
		String[][] cloud = new String[H][W];
		for (int i = 0; i < H; i++) {
			String s = sc.next();
			for (int j = 0; j < W; j++) {
				cloud[i][j] = s.substring(j, j+1);
			}
		}
		for (int i = 0; i < H; i++) {
			int cnt = -1;
			boolean isC = false;
			for (int j = 0; j < W; j++) {
				if(cloud[i][j].equals("c")) {
					isC = true;
					cnt = 0;
					answer[i][j] = cnt++;
				}else {
					answer[i][j] = isC ? cnt++ : -1;
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
}
