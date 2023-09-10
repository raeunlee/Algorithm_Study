import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[101];
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		for (int i = 4; i <= 100; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		long[] answer = new long[N];
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			answer[i] = arr[a];
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
