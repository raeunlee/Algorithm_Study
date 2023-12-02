import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] num = new int[11][];
		num[0] = new int[] {1, 1, 1, 0, 1, 1, 1};
		num[1] = new int[] {0, 0, 1, 0, 0, 1, 0};
		num[2] = new int[] {1, 0, 1, 1, 1, 0, 1};
		num[3] = new int[] {1, 0, 1, 1, 0, 1, 1};
		num[4] = new int[] {0, 1, 1, 1, 0, 1, 0};
		num[5] = new int[] {1, 1, 0, 1, 0, 1, 1};
		num[6] = new int[] {1, 1, 0, 1, 1, 1, 1};
		num[7] = new int[] {1, 1, 1, 0, 0, 1, 0};
		num[8] = new int[] {1, 1, 1, 1, 1, 1, 1};
		num[9] = new int[] {1, 1, 1, 1, 0, 1, 1};
		num[10] = new int[] {0, 0, 0, 0, 0, 0, 0};
		for (int i = 0; i < T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int answer = 0;
			int n1 = 0;
			int n2 = 0;
			int[] arr1 = new int[5];
			int[] arr2 = new int[5];
			
			int z = 10000;
			for (int j = 0; j < 5; j++) {
				if(j == 0) {
					arr1[j] = a/z > 0 ? a/z : 10;
					arr2[j] = b/z > 0 ? b/z : 10;
				}else {
					arr1[j] = a/z > 0 ? a/z : arr1[j-1] != 10 ? 0 : 10;
					arr2[j] = b/z > 0 ? b/z : arr2[j-1] != 10 ? 0 : 10;
				}
				a = a/z > 0 ? a%z : a;
				b = b/z > 0 ? b%z : b;
				z /= 10;
			}

			for (int j = 0; j < arr2.length; j++) {
				for (int j2 = 0; j2 < 7; j2++) {
					if(num[arr1[j]][j2] == num[arr2[j]][j2]) continue;
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
}
