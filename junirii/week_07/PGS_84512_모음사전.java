import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public static String[] wordArr = {"A", "E", "I", "O", "U"};
	public static List<String> list = new ArrayList<>();
	public static StringBuilder sb;
    
    public int solution(String word) {
       int answer = 0;

		dfs("");
		Collections.sort(list);
		answer = list.indexOf(word)+1;
		
        return answer;
    }
    
    public void dfs(String s) {
        if(s.length() == 5) return;

        sb = new StringBuilder(s);
        for (int i = 0; i < wordArr.length; i++) {
            sb.append(wordArr[i]);
            list.add(sb.toString());
            dfs(sb.toString());
            sb.delete(sb.length()-1, sb.length());
        }
	}
}
