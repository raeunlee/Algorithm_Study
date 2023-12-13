import java.util.Arrays;
import java.util.Scanner;

public class boj20115 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] drink = new int[n];
		for(int i=0; i<n; i++) {
			drink[i]=sc.nextInt();
		}

		Arrays.sort(drink);
		for(int i=0;i<n/2;i++) {
			int temp = drink[i];
			drink[i]=drink[n-1-i];
			drink[n-1-i]=temp;
		}
		
		double ed=drink[0];
		for(int i=0;i<n-1;i++) {
			//System.out.println(drink[i]+"?");
			ed=ed+(double)drink[i+1]/2;
		}
		System.out.println(ed);
	}
}