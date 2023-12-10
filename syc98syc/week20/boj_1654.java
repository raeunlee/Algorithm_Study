import java.io.*;
import java.util.*;
//보충이해필요
public class boj1654 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[K];
		long end = 0;
		for(int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(end < arr[i]) end = arr[i];
		}
		
		long start = 1;
		long mid = (end + start) / 2;
		long result = end;
		
		while(end - start >= 0) {
			long sum = 0;
			for(int i = 0; i < K; i++) {
				sum += (arr[i] / mid);
			}
			
			if(sum >= N) {
				start = mid + 1;
				result = mid;
			}else {
				end = mid - 1;
			}
			
			mid = (end + start) / 2;
		}
		System.out.println(result);
	}
}