import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[101];
		for (int i = 0; i < 3; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			for (int j = s+1; j <= e; j++) {
				arr[j]++;
			}
		}
		int answer = 0;
		for (int i : arr) {
			if(i == 0) continue;
			if(i == 1) answer += a;
			else if(i == 2) answer += b*2;
			else answer += c*3; 
		}
		System.out.println(answer);
	}
}
