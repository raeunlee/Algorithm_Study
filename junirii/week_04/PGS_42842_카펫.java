import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n = brown + yellow;
        int sqrt = (int)Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
			if(n%i == 0) {
				list.add(i);
				if(n/i != i) {
					list.add(n/i);
				}
			}
		}
        Collections.sort(list);
        for (int i = 0, j = list.size()-1; i <= list.size()/2; i++, j--) {
			if(list.get(i) > 2 && list.get(i) + list.get(j) == (brown+4)/2 && list.get(i) * list.get(j) - yellow == brown) {
				answer[0] = list.get(j);
				answer[1] = list.get(i);
				break;
			}
		}
        
        return answer;
    }
}
