import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int count;
    static List<int[]> points;
    public static void main(String[] args) {
        // 한번 지난 곳 못가고 준 배열만 방문할 수 있으면 된다.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = sc.nextInt();

        board = new int[n][n];

        visited = new boolean[n][n];

        count = 0;
        
        for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    {
                        board[i][j] = sc.nextInt();
                    }
            }

        points = new ArrayList<>();

        for(int i=0;i<m;i++){
            points.add(new int[]{sc.nextInt()-1,sc.nextInt()-1});         
        }

        // count 파라미터를 넘기면서 points 모든 인덱스에 접근하면서 순서가 맞는 지 확인하며 dfs를 돌아봅시다.
        dfs(points.get(0)[0],points.get(0)[1],1);        

        System.out.println(count);
    }
    public static void dfs(int x, int y, int idx){
        // 마지막 인덱스를 방문 후 도착했을 경우 count증가
        if(idx==m){
            count++;
            return;
        }
        for(int i=0;i<4;i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isRange(nx,ny)){
                    if(!visited[nx][ny]){
                        // 빈 칸에만 이동 가능
                        if(board[nx][ny]==0){
                            // 현재 인덱스 지나가야하는 지점이라면
                            if(points.get(idx)[0]==nx && points.get(idx)[1] ==ny){
                                visited[nx][ny] = true;
                                // 인덱스 증가 후 dfs
                                dfs(nx,ny,idx+1);
                            }
                            // 순서를 다르게 갔을경우를 체크
                            else
                            {
                                boolean isWrong = false; // 순서를 맞게 가는 지 확인할 변수
                                for(int j=0;j<m;j++)
                                    {
                                        // 하나라도 순서에 맞지 않게 갔을 경우 isWrong을 true로 반환
                                        if(points.get(j)[0]==nx && points.get(j)[1]==ny){
                                            isWrong = true;
                                            break;
                                        }
                                    }
                                // 순서에 안 맞을 경우 다음 반복으로
                                if(isWrong){
                                    continue;
                                }
                                // 순서에 맞다면 idx는 그대로 유지 후 다음 dfs로               
                                else{
                                    visited[nx][ny] = true;
                                    dfs(nx,ny,idx);
                                }
                            }
                            visited[nx][ny]= false;
                        }
                    }
                }
            }
    }
    public static boolean isRange(int x,int y)
    {
        return x>=0 && y>=0 && x<n && y<n;
    }
}                               
