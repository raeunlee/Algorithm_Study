class Solution {
    public int solution(String name) {
        int answer = 0;
		int move = name.length() - 1;
		
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
			if (i < name.length()-1 && name.charAt(i+1) == 'A') {
                int end_A_idx = i+1;
                while(end_A_idx < name.length() && name.charAt(end_A_idx) == 'A')
                	end_A_idx++;
                move = Math.min(move, i*2 + (name.length() - end_A_idx));
                move = Math.min(move, i + (name.length() - end_A_idx)*2);
            }
		}
		answer += move;
		
		return answer;
    }
}
