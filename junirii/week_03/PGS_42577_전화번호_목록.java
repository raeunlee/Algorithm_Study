package programmers.p42577;

import java.util.Arrays;

public class Solution {
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for (int i = 0; i < phone_book.length-1; i++) {
        	if(phone_book[i+1].indexOf(phone_book[i]) == 0) answer = false;
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		boolean a = solution(new String[] {"119", "97674223", "1195524421"});
		System.out.println(a);
	}
}
