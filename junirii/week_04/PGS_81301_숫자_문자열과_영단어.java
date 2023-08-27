class Solution {
    public int solution(String s) {
       int answer = 0;
        String[] arr = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven"
        		, "eight", "nine"};
        String[] arr2 = new String[] {"0", "1", "2", "3", "4", "5", "6", "7"
        		, "8", "9"};
        
        for (int i = 0; i < arr.length; i++) {
        	if(s.contains(arr[i])) s = s.replace(arr[i], arr2[i]);
		}
        answer = Integer.parseInt(s);
        return answer;
    }
}
