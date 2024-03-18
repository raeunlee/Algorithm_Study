import java.io.*;
import java.util.*;

public class boj21921_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] visitNum = new int[N];
		int sum=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			visitNum[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<X; i++) {
			sum += visitNum[i];
		}
		int max=sum;
		int count=1;
		
		for(int i=X; i<N; i++) {
			sum +=visitNum[i];
			sum -=visitNum[i-X];
			if(max<sum) {
				max=sum;
				count=1;
			}
			else if(max==sum) {
				count++;
			}
			
		}
		
		if(max==0)
			System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.print(count);
		}	
	}
}

