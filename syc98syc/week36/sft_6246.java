import java.io.*;
import java.util.*;

public class Main {
	static int[][] d = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N,M;
	static int[][] matrix;
	static boolean[][] visited;
	static List<int[]> checkPoints = new ArrayList<>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		matrix = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0])-1;
			int y = Integer.parseInt(input[1])-1;
			checkPoints.add(new int[] {x,y}); //
		}
		
		
		visited[checkPoints.get(0)[0]][checkPoints.get(0)[1]] = true;
		dfs(checkPoints.get(0)[0], checkPoints.get(0)[1],0);
		
		System.out.println(result);
	}

	private static void dfs(int x, int y, int depth) {
		if(depth==M) {
			result +=1;
			return;
		}
		
		if(x==checkPoints.get(depth)[0] && y==checkPoints.get(depth)[1]) {
			dfs(x,y,depth+1);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nX = x + d[i][0];
			int nY = y + d[i][1];
			
			if(nX <0 || nY <0 || nX >= N || nY >= N) continue;
			
			if(matrix[nX][nY]==1) continue;
			
			if(visited[nX][nY]) continue;
			
			visited[nX][nY] = true;
			dfs(nX, nY, depth);
			visited[nX][nY] =false;
		}
	}
}