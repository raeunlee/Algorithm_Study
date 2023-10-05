import java.util.Scanner;

public class Main {
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double N = sc.nextDouble();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int len = (int)Math.pow(2, N);
		find(len, r, c);
		System.out.println(cnt);
	}
	
	static void find(int len, int r, int c) {
		if(len == 1) return;
		
		if(r < len/2 && c < len/2) { //1
			find(len/2, r, c);
		}else if(r < len/2 && c >= len/2) { //2
			cnt += len*len/4;
			find(len/2, r, c-(len/2));
		}else if(r >= len/2 && c < len/2) { //3
			cnt += len*len/4*2;
			find(len/2, r-(len/2), c);
		}else { //4
			cnt += len*len/4*3;
			find(len/2, r-(len/2), c-(len/2));
		}
	}
}
