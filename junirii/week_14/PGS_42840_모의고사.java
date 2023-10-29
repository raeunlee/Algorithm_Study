class Solution {
    public int[] solution(int[] answers) {
        int f = 0;
		int s = 0;
		int t = 0;
		
		for (int i = 0; i < answers.length; i++) {
			// 1번 수포자
			int idx1 = (i+1)%5;
			int num1 = idx1 == 0 ? 5 : idx1;
			
			// 2번 수포자
			int idx2 = (i+1)%8;
			int num2 = 2;
			if(idx2 % 2 == 0) {
				switch(idx2) {
					case 2:
						num2 = 1;
						break;
					case 4:
						num2 = 3;
						break;
					case 6:
						num2 = 4;
						break;
					case 0:
						num2 = 5;
						break;
				}
			}
			
			// 3번 수포자
			int idx3 = (i+1)%10; 
			int num3 = 0;
			if(idx3 == 0 || idx3 == 9) {
				num3 = 5;
			}else if(idx3 <= 2) {
				num3 = 3;
			}else if(idx3 <= 4) {
				num3 = 1;
			}else if(idx3 <= 6) {
				num3 = 2;
			}else if(idx3 <= 8) {
				num3 = 4;
			}
			
			if(answers[i] == num1) f++;
			if(answers[i] == num2) s++;
			if(answers[i] == num3) t++;
		}
		
		int max = Math.max(f, s);
		max = Math.max(max, t);
		
		int i = 0;
		int[] answer_tmp = new int[3];
		if(f == max) {
			answer_tmp[i++] = 1;
		}
		if(s == max) {
			answer_tmp[i++] = 2;
		}
		if(t == max) {
			answer_tmp[i++] = 3;
		}
		
		int[] answer = new int[i];
		for (int j = 0; j < answer.length; j++) {
			answer[j] = answer_tmp[j];
		}
		return answer;
    }
}
