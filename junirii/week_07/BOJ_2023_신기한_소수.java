import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static int[] numArr;
	public static int N;
	public static List<Integer> ansList = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = {2, 3, 5, 7};
		numArr = new int[N+1];
		
		for (int i = 0; i < arr.length; i++) {
			numArr[1] = arr[i];
			getNum(2);
		}
		for (int i : ansList) {
			System.out.println(i);
		}
	}
	
	public static void getNum(double idx) {
		if(idx > N) {
			int num_tmp = 0;
			for (int i = 1; i < numArr.length; i++) {
				num_tmp += numArr[i] * Math.pow(10, N-i);
			}
			ansList.add(num_tmp);
			return;
		}
		int num = 0;
		for (double i = 1; i < idx; i++) {
			num += numArr[(int)i] * Math.pow(10, idx-i);
		}
		for (int i = 1; i < 10; i+=2) {
			num += i;
			int cnt = 0;
			for (int j = 1; j*j <= num; j++) {
				if(j*j == num) cnt++;
				else if(num%j == 0) cnt+=2;
			}
			if(cnt == 2) {
				numArr[(int)idx] = i;
				getNum(idx+1);
			}
			num -= i;
		}
	}
}
