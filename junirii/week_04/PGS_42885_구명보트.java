import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
       int answer = 0;
		int idx = 0;
		Arrays.sort(people);
		for (int i = people.length-1; i >= 0 ; i--) {
			if(idx > i) break;
			if(people[i] + people[idx] <= limit) {
				idx++;
			}
			answer++;
		}
        return answer;
    }
}
