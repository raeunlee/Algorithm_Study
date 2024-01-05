import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 주소의 수
        StringBuilder sb = new StringBuilder();

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}