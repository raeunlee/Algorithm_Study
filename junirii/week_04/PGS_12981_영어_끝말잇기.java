package programmers.p12981;

import java.util.HashSet;

public class Solution {
	public static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> hs = new HashSet<String>();
        hs.add(words[0]);
        for (int i = 1; i < words.length; i++) {
			hs.add(words[i]);
			if(hs.size() != i+1 || words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
				answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
				answer[1] = (i+1)%n == 0 ? (i+1)/n : (i+1)/n+1;
				break;
			}
		}
        
        return answer;
    }
}
