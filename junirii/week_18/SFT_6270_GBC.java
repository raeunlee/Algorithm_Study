import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] el = new int[n][];
		int[][] test = new int[m][];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			el[i] = new int[] {a, b};
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			test[i] = new int[] {a, b};
		}
		
		int answer = 0;
		int idx_el = 0;
		int idx_test = 0;
		while(test[m-1][0] > 0) {
			if(test[idx_test][0] < el[idx_el][0]) {
				el[idx_el][0] -= test[idx_test][0];
				test[idx_test][0] = 0;
				if(test[idx_test][1] > el[idx_el][1]) answer = Math.max(answer, test[idx_test][1] - el[idx_el][1]);
				idx_test++;
			}else if(test[idx_test][0] > el[idx_el][0]) {
				test[idx_test][0] -= el[idx_el][0];
				el[idx_el][0] = 0;
				if(test[idx_test][1] > el[idx_el][1]) answer = Math.max(answer, test[idx_test][1] - el[idx_el][1]);
				idx_el++;
			}else {
				test[idx_test][0] = 0;
				el[idx_el][0] = 0;
				if(test[idx_test][1] > el[idx_el][1]) answer = Math.max(answer, test[idx_test][1] - el[idx_el][1]);
				idx_el++;
				idx_test++;
			}
		}
		System.out.println(answer);
	}
}
