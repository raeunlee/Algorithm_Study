import java.util.HashSet;

class Solution {
    static char[] arr;
	static boolean[] visited;
	static HashSet<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        arr = new char[numbers.length()];
		visited = new boolean[numbers.length()];
		
		for (int i = 0; i < numbers.length(); i++) {
			arr[i] = numbers.charAt(i);
		}
		
		dfs("", 0);
		
		return hs.size();
    }
    
    static void dfs(String str, int idx) {
		int num;
		if(!str.equals("")) {
			num = Integer.parseInt(str);
			if(isPrime(num)) hs.add(num);
		}
		if(idx == arr.length) return;
		
		for (int i = 0; i < arr.length; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			dfs(str+arr[i], idx+1);
			visited[i] = false;
		}
	}
	
	static boolean isPrime(int num) {
		if(num == 0 || num == 1) return false;
		for (int i = 2; i <= num/2; i++) {
			if(num % i == 0) return false;
		}
		return true;
	}
    
}
