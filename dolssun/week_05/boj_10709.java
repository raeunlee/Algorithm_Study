package week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 10709 : 기상캐스터

public class boj_10709 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		String[] c_li = new String[h];
		int[][] t_li = new int[h][];
		for(int i=0; i<h; i++) {
			t_li[i] = new int[w];
			for(int j=0; j<w; j++) {
				t_li[i][j] = -1;
			}
		}
		
		for(int i=0; i<h; i++) {
//			t_li[i] = new int[w];
			c_li[i] = br.readLine();
		}
		
		for(int i=0; i<h; i++) {
			for(int j=w-1; j>=0; j--) {
				char c = c_li[i].charAt(j);
				if(c=='c') {
					t_li[i][j] = 0;
				}else {
					int k = j-1;
					while(true) {
						if(k<0)
							break;
						if(c_li[i].charAt(k)=='c') {
							t_li[i][j] = j-k;
							break;
						}else {
							k-=1;
						}
					}
				}
			}
		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.print(t_li[i][j]+ " ");
			}
			System.out.println();
		}
		
	}//end main
}//end class
