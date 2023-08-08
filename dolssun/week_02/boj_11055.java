package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());	//수의 개수
		int m = Integer.parseInt(st.nextToken());	//합의 횟수
		
		s = br.readLine();	//5 4 3 2 1
		st = new StringTokenizer(s);
		int[] S = new int[n+1];	// 합의 배열
		for (int i = 1; i < S.length; i++) {
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());	// 이전합 + 현재입력숫자
			
		}
		
		// 합의 횟수
		for (int i = 0; i < m; i++) {
			s = br.readLine();	// 1 3
			st = new StringTokenizer(s);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// 분합의 공식 S[end]-S[start-1]
			System.out.println(S[end]-S[start-1]);
		}
		
	}
}