import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N+1][3];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[num][0] = sc.nextInt();
			arr[num][1] = sc.nextInt();
			arr[num][2] = sc.nextInt();
		}
		
		int rank = 1;
		for (int i = 1; i < arr.length; i++) {
			if(i == K) continue;
			
			if(arr[K][0] < arr[i][0]) rank++;
			else if(arr[K][0] == arr[i][0]) {
				if(arr[K][1] < arr[i][1]) rank++;
				else if(arr[K][1] == arr[i][1]) {
					if(arr[K][2] < arr[i][2]) rank++;
				}
			}
		}
		System.out.println(rank);
	}
}
