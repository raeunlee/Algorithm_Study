import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sft_6297 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String token[] = br.readLine().split(" ");
		int n = Integer.parseInt(token[0]);
		int k = Integer.parseInt(token[1]);
		
		int[] test = new int[n];
		String token2[] = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			test[i]=Integer.parseInt(token2[i]);
		}
		
		for(int i=0;i<k;i++) {
			String token3[] = br.readLine().split(" ");
			int start=Integer.parseInt(token3[0]);
			int end=Integer.parseInt(token3[1]);
			int sum=0;
			for(int j=start-1;j<=end-1;j++) {
				sum+=test[j];
			}
			float num = (float)sum/(end-start+1);
			String ans = String.format("%.2f", num);
			System.out.println(ans);
		}
	}
}