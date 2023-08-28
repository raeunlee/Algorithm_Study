package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1157{
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		String s = br.readLine();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
				arr[s.charAt(i)-'A'] += 1;
			}else if(s.charAt(i)>='a' && s.charAt(i) <= 'z'){
				arr[s.charAt(i)-'a'] += 1;
			}	
		}
		
		int max = -1;
		char answer = '?';
		for(int i=0; i<26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char)(i+'A');
			}else if(arr[i] == max){
				answer = '?';
			}
			
		}
		
		System.out.println(answer);
		
		
	}
}
