class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
			String b1 = Integer.toBinaryString(arr1[i]);
			String b2 = Integer.toBinaryString(arr2[i]);
			if(b1.length() != n) {
				while(b1.length() < n){
					b1 = "0" + b1;
				}
			}
			if(b2.length() != n) {
				while(b2.length() < n){
					b2 = "0" + b2;
				}
			}
			String s = "";
			for (int j = 0; j < n; j++) {
				if(b1.charAt(j) == '0' && b2.charAt(j) == '0') s += " ";
				else s += "#";
			}
			answer[i] = s;
		}
        
        return answer;
    }
}
