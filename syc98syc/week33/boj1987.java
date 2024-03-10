import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 {
	static int R, C;
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int ans = 1;
	static boolean[] alpha= new boolean[26];
	
	public static void dfs(int x, int y, int count) {
		if(alpha[map[x][y]]) {
			ans=Math.max(ans, count);
			return;
		}else {
			alpha[map[x][y]]=true;
			count++;
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx>=0 && cy>=0 && cx<R && cy<C)
					dfs(cx,cy,count);
			}
			alpha[map[x][y]]=false;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=s.charAt(j)-'A';
			}
		}
		
		dfs(0,0,0);
		System.out.println(ans);
	}

}
