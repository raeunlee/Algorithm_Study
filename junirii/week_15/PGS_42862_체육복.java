class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
		int[] students = new int[n+1];
		for (int i = 1; i < students.length; i++) {
			students[i]++;
		}
		for (int i : lost) {
			students[i]--;
		}
		for (int i : reserve) {
			students[i]++;
		}
		for (int i = 1; i < students.length; i++) {
			if(i > 0 && students[i] == 0 && students[i-1] >= 2) {
				students[i]++;
				students[i-1]--;
			}
			if(i < students.length-1 && students[i] == 0 && students[i+1] >= 2) {
				students[i]++;
				students[i+1]--;
			}
		}
		for (int i : students) {
			if(i > 0) answer++;
		}
		return answer;
    }
}
