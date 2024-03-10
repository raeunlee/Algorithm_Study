import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj20365 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = br.read();
		br.readLine();
		String s = br.readLine();
		char[] arr = new char[s.length()];
		int countB=0;
		boolean isR = false;
		boolean isB = false;
		int count=1;
		
		for(int i=0; i<s.length(); i++) {
			arr[i]= s.charAt(i);
			if(arr[i]=='B')
				countB++;
		}
		
		if(countB>=s.length()-countB) {
			for(int i=0; i<s.length(); i++) {
				if(arr[i]=='R') {
					if(isR==false)
						count++;
					isR=true;
				}
				else isR=false;
			}
		}
		else {
			count=0;
			for(int i=0; i<s.length(); i++) {
				if(arr[i]=='B') {
					if(isB==false)
						count++;
					isB=true;
				}
				else isB=false;
			}
		}
		
		System.out.println(count);
	}
}
