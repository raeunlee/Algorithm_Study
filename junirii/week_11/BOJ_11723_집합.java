import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int S = 0;
		for (int i = 0; i < n; i++) {
			String l = br.readLine();
			st = new StringTokenizer(l);
			String s = st.nextToken();
			switch(s) {
				case "all":
					S = (1 << 21) - 1;
					break;
				case "empty":
					S = 0;
					break;
				default:
					int num = Integer.parseInt(st.nextToken());
					if(s.equals("add")) {
						S |= (1 << num);
					}else if(s.equals("remove")) {
						S &= ~(1 << num);
					}else if(s.equals("check")) {
						int print = (S & (1 << num)) == (1 << num) ? 1 : 0;
						sb.append(print + "\n");
					}else {
						S ^= (1 << num);
					}
					break;
			}
		}
		System.out.println(sb);
	}
}
