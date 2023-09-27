import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		ArrayList<String>[] arr = new ArrayList[201];
		StringTokenizer st;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(sc.nextLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			if(arr[age] == null) arr[age] = new ArrayList<String>();
			arr[age].add(name);
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == null) continue;
			if(arr[i].size() > 1) {
				for (String s : arr[i]) {
					System.out.println(i + " " + s);
				}
			}else {
				System.out.println(i + " " + arr[i].get(0));
			}
		}
	}
}
