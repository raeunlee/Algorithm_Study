import java.util.Scanner;

public class Main {
	public static int N, max, min;
	public static int[] math, arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		math = new int[4];
		for (int i = 0; i < 4; i++) {
			math[i] = sc.nextInt();
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void dfs(int num, int idx) {
		if(idx == N) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(math[i] > 0) {
				math[i]--;
				switch(i) {
					case 0:
						dfs(num+arr[idx], idx+1);
						break;
					case 1:
						dfs(num-arr[idx], idx+1);
						break;
					case 2:
						dfs(num*arr[idx], idx+1);
						break;
					case 3:
						dfs(num/arr[idx], idx+1);
						break;
				}
				math[i]++;
			}
		}
	}
}
