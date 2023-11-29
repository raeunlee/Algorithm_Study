import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int W = sc.nextInt();
		int n = sc.nextInt();
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			q.add(new int[] {a, b});
		}
		
		int answer = 0;
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			if(W > arr[0]) {
				W -= arr[0];
				answer += arr[0] * arr[1];
			}else {
				answer += W * arr[1];
				break;
			}
		}
		
		System.out.println(answer);
	}
}
