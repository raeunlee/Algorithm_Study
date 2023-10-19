import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int p = sc.nextInt();
		for (int i = 0; i < p; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
			if(arr[num] == 0) arr[num]++;
			else arr[num]--;
			
			if(s == 1) { // 남자
				for (int j = 2; num*j <= N; j++) {
					if(arr[num*j] == 0) arr[num*j]++;
					else arr[num*j]--;
				}
			}else { // 여자
				int j = 1;
				while(num-j >= 1 && num+j <= N && arr[num-j] == arr[num+j]) {
					if(arr[num-j] == 0) {
						arr[num-j]++;
						arr[num+j]++;
					}else {
						arr[num-j]--;
						arr[num+j]--;
					}
					j++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i]+" ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
