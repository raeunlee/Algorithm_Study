class Solution {
    public int solution(String s) {
int answer = 1000;
        if(s.length() < 2) {
            return s.length();
        }
        for (int i = 1; i < s.length()/2+2; i++) {
			String s_result = "";
			String s_subStr = s.substring(0, i);
			int cnt = 1;
			int last_idx = 0;
			for (int j = i; j <= s.length()-1; j+=i) {
				String s_compare = "";
				if(j+i > s.length()-1) s_compare = s.substring(j, s.length());
				else s_compare = s.substring(j, j+i);
				if(s_compare.equals(s_subStr)){
					cnt++;
				}else {
					if(cnt > 1) {
						s_result += cnt;
						cnt = 1;
					}
					s_result += s_subStr;
					s_subStr = s_compare;
				}
				last_idx = j+i;
			}
			if(cnt > 1)
				s_result += cnt;
			s_result += s_subStr;
			
			if(last_idx < s.length()) {
				s_result += s.substring(last_idx);
			}
			
			answer = Math.min(s_result.length(), answer);
			s_result = "";
		}
        return answer;
    }
}
