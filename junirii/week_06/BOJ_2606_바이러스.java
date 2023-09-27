import java.util.Scanner;

public class Main {
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		int cnt = 0;
		for (int i = 2; i <= N; i++) {
			if(find(i) == find(1)) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			if(a <= b) parent[b] = a;
			else parent[a] = b;
		}
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
}
