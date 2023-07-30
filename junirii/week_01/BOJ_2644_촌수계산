import java.util.Scanner;

public class Main {
	private static int[] parent;
	private static int cnt, ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		parent = new int[N+1];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			parent[y] = x;
		}
		
		System.out.println(find(a, b, 0));
	}
	
	public static int find(int a, int b, int cnt) {
		if(findParent(a) != findParent(b)) return -1;
		if(a == b) return cnt;
		if(getChon(a, 0) <= getChon(b, 0)) {
			return find(a, parent[b], cnt+1);
		}
		return find(parent[a], b, cnt+1);
	}
	
	public static int getChon(int i, int chon) {
		if(parent[i] == 0) return chon;
		return getChon(parent[i], chon+1);
	}
	
	public static int findParent(int i) {
		if(parent[i] == 0) return i;
		return findParent(parent[i]);
	}
}
