import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class boj17219 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		HashMap<String,String> pWM = new HashMap<String,String>();
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			pWM.put(input[0], input[1]);
		}
		
		for(int i=0; i<M; i++) {
			String site = br.readLine();
			System.out.println(pWM.get(site));
		}
	}
}
