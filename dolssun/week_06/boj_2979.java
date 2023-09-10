package week06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2979 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int a,b,c;
		int[] arr = new int[101];
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<=y; j++) {
				arr[j] += 1;
			}
		}
		
		for(int i=1; i<10; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		int answer = 0;
		for(int i=1; i<=100; i++) {
			if(arr[i]==1) {
				answer += a*1;
			}else if(arr[i]==2) {
				answer += b*2;
			}else if(arr[i]==3) {
				answer += c*3;
			}
			System.out.println(i + ": " + answer);
		}
		
//		System.out.println(answer);
	
	}
}
