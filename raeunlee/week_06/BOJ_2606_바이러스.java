import java.io.*;
import java.util.*;

public class Main {
	static int com[][] ;
	static boolean visited[];
	static int count = 0;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st;
		  N = Integer.parseInt(br.readLine()); // 컴퓨터 수 
	      M = Integer.parseInt(br.readLine()); // 네트워크 수 
	      
	      com = new int[N+1][N+1];
	      visited = new boolean[N+1];

	      for(int i =0; i <M; i++) { // 네트워크 수만큼 
	    	 st = new StringTokenizer(br.readLine());
	    	 int c1  = Integer.parseInt(st.nextToken());
	    	 int c2 = Integer.parseInt(st.nextToken());
	    	 com[c1][c2] = 1;
			 com[c2][c1] = 1; // 인접 행렬 만들어 주기 
	     }
	      DFS(1);
	      System.out.println(count);
	}
	public static void DFS(int start) { 
		
		visited[start] = true; //방문시 true 
		
		
		for(int i = 0 ; i <= N ; i++) {
			if(com[start][i] == 1 && visited[i]==false) { // 방문하지 않았을 경우 
				DFS(i); // 다시 순회 
				count++;
		}
		}
	}
	
	
}
