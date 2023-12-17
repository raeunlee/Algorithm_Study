import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 듣
        int m = Integer.parseInt(st.nextToken()); // 보
        Set<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            if (set.contains(str)) {
                result.add(str);
            }
        }
        Collections.sort(result);
        sb.append(result.size()).append("\n");
        for (String str : result) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}