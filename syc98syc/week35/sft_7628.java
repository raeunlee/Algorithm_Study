import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int[] arr = new int[n];
		String[] s = sc.nextLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		int answer = Integer.MIN_VALUE;
		
		for(int i=2; i<=100; i++) {
			int count=0;
			for(int j=0; j<n; j++) {
				if(arr[j]%i==0)
					count++;
			}
			answer = Integer.max(answer, count);
		}
		System.out.println(answer);
    }
}