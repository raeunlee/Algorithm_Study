import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			long N = sc.nextLong();
			long M = sc.nextLong();
			long a = 1;
			for (int j = 0; j < N; j++) {
				a *= M-j;
				a /= j+1;
			}
			System.out.println(a);
		}
	}
}
