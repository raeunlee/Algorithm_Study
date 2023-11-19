class Solution {
    boolean solution(String s) {
        boolean answer = true;
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.substring(i, i+1).equals("(")) start++;
			else end++;
			if(end > start) {
				answer = false;
				break;
			}
		}
		if(start != end) answer = false;
		return answer;
    }
}
