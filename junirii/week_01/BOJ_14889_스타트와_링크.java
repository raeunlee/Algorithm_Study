import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	private static int[][] arr;
	private static int n;
	private static ArrayList<Integer> ansList = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				check(i, j);
			}
		}
		Collections.sort(ansList);
	}
	
	public static void check(int a, int b) {
		int val1 = arr[a][b] + arr[b][a];
		for (int i = 1; i <= n; i++) {
			for (int j = i+1; j <= n; j++) {
				if(i != a && i != b && j != a && j != b) {
					int val2 = arr[i][j] + arr[j][i];
					ansList.add(Math.abs(val1 - val2));
					System.out.println("val1:"+a+"+"+b+"="+val1+"/val2:"+i+"+"+j+"="+val2+"/gap:"+Math.abs(val1 - val2));
				}
			}
		}
	}
}
