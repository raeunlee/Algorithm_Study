import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj6064_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int M,N,x,y;
		for(int i=0; i<T; i++) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			x = Integer.parseInt(input[2])-1;
			y = Integer.parseInt(input[3])-1;
			boolean check = false;
			
			for (int k = x; k < (N * M); k += M) {
				if (k % N == y) {
					System.out.println(k + 1);
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println(-1);

			}
		}
	}

}
