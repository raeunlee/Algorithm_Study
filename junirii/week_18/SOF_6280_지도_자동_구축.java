import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int square_cnt = 1;
		for (int i = 0; i < n; i++) {
			square_cnt *= 4;
		}
		int answer = (int)Math.sqrt(square_cnt)+1;
		System.out.println(answer * answer);
	}
}
