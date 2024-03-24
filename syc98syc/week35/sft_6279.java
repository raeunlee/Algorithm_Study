import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String s = sc.next();
		char[] arr = new char[N];
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i);
		}
		
		int ans=0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=='P') {
				for(int j=i-K; j<= i+K; j++) {
					if(j<0||j>=N) continue;
					if(arr[j]=='H') {
						arr[j]='X';
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

}