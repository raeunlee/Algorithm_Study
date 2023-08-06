import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		res[0] = arr[0];
		for (int i = 1; i < N; i++) {
			res[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					res[i] = Math.max(res[j] + arr[i], res[i]);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(res[i], max);
		}
		System.out.println(max);
	}
}
