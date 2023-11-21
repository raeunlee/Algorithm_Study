import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
	static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(list);
		return list.get(0).split(" ");
    }
    
    static void dfs(int depth, String start, String path, String[][] tickets) {
		if(depth == tickets.length) {
			list.add(path);
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if(tickets[i][0].equals(start) && visited[i] == false) {
				visited[i] = true;
				dfs(depth+1, tickets[i][1], path+" "+tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}
