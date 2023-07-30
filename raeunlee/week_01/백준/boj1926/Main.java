//package boj1926;
//
//import java.util.*;
//
//public class Main {
//	
//	static int n, m;
//	static int[][] map;
//	static boolean[][] check; //방문했는지 확인
//	
//	//방향 - 왼쪽, 오른쪽, 아래, 위 
//	static int[] dx = {-1, 1, 0, 0}; 
//	static int[] dy = {0,0,-1,1};
//	
//	static Queue<Node> queue;
//	
//	//큐에 좌표를 넣어줄 클래스 
//	public class Node {
//		int x, y;
//		public Node(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//		public int getX() {
//			return x;
//		}
//		public void setX(int x) {
//			this.x = x;
//		}
//		public int getY() {
//			return y;
//		}
//		public void setY(int y) {
//			this.y = y;
//		}
//	}
//	
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		n = sc.nextInt();
//		m = sc.nextInt();
//		map  =new int[m][n]; 
//		//m가로 n세로 
//		
//		for (int i = 0; i < m; i++) {
//			for (int j=0; j < n; j++) {
//				map[i][j] = sc.nextInt();
//			}
//		} // end for
//		
//		check = new boolean[m][n];
//		
//		 // 시작!
//        int count = 0;
//        int area = 0;
//        int max = 0;
//        
//		for (int i = 0; i < n; i++) {
//			for(int j = 0; j < m; j ++) {
//				if(map[i][j] == 0 || check[i][j]) {
//					continue; // 0 이거나 방문을 했을 경우 
//				}
//				count ++; // 1이고, 방문을 안한 경우 +1
//				
//				queue.offer(new Node(i,j));  //큐에 좌표 넣어주기 
//				
//			}
//			
//		}
//		
//		
//		
//	}
//	
//
//}
