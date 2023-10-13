import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Queue<int[]> q = new LinkedList<>();
			int[] important = new int[10];
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				int[] arr = {j, a};
				q.add(arr);
				important[a]++;
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				int max = 0;
				for (int j = 9; j >= 1; j--) {
					if(important[j] > 0) {
						max = j;
						break;
					}
				}
				int[] arr = q.poll();
				if(arr[1] == max) {
					important[arr[1]]--;
					cnt++;
					if(arr[0] == M) break;
				}else {
					q.add(arr);
				}
			}
			System.out.println(cnt);
		}
	}
}
