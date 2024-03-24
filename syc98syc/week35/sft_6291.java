import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Node[] time = new Node[N];
		
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split(" ");
			time[i] = new Node(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		}
		
		Arrays.sort(time);
		
		int ans = 0;
		int curTime = 0;
		
		for(Node t : time) {
			if(t.start<curTime) {
				continue;
			}else {
				ans++;
				curTime = t.end;
			}
		}
		System.out.println(ans);
	}
	
	static class Node implements Comparable<Node>{
		int start;
		int end;
		
		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Node o) {
			return this.end - o.end; //오름차순
		}
		
	}
}