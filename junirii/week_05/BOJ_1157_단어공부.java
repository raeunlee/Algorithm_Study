import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		word = word.toUpperCase();
		int[] arr = new int[26];
		for (int i = 0; i < word.length(); i++) {
			arr[(int)(word.charAt(i))-65]++;
		}
		char answer = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char)(i+65);
			}else if(arr[i] == max) {
				answer = '?';
			}
		}
		System.out.println(answer);
	}
}
