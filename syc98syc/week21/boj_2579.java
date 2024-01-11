import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] DP = new int[n+1];
		DP[1]=arr[1];
		
		if(n>=2)
			DP[2]=arr[1]+arr[2];
		
		for(int i=3; i<=n; i++) {
			DP[i] = Math.max(DP[i-2], DP[i-3]+arr[i-1])+arr[i];
		}
		
		System.out.print(DP[n]);
		
	}

}