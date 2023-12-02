import java.io.*;
import java.util.*;

public class Main {
    static int[][] blocks;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      blocks = new int[n][n];
      visited= new boolean[n][n];
      ArrayList<Integer> list = new ArrayList<>();
      for(int i=0;i<n;i++)
        {
          st = new StringTokenizer(br.readLine());
          String s = st.nextToken();
          for(int j=0;j<n;j++)
            {
               blocks[i][j] = s.charAt(j)-'0';              
            }
        }
      int count =0;
      for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
            {
              if(!visited[i][j] && blocks[i][j]==1){
                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                int[] dx = {-1,1,0,0};
                int[] dy = {0,0,-1,1};
                queue.add(new int[]{i,j});
                int size=1;
                while(!queue.isEmpty()){
                  int[] cur = queue.poll();
                  for(int k=0;k<4;k++)
                    {
                      int nx = dx[k]+cur[0];
                      int ny = dy[k]+cur[1];
                        if(nx>=0&&ny>=0&&nx<n&&ny<n){
                      if(!visited[nx][ny]&&blocks[nx][ny]==1){
                          visited[nx][ny]=true;
                          queue.add(new int[]{nx,ny});
                          size++;
                        }
                      }
                    }
                }
                list.add(size);
                count++;
              }
            }
        }
      int[] ans = new int[count];
      for(int i=0;i<count;i++){
        ans[i] = list.get(i); 
      }
      Arrays.sort(ans);
      System.out.println(count);
      for(int i=0;i<count;i++)
        {
          System.out.println(ans[i]);
        }
    }
}
