import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        int m = Integer.parseInt(br.readLine()); // 고장난 버튼 개수

        boolean[] broken = new boolean[10]; // 0 ~ 9
        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int num = Integer.parseInt(st.nextToken());
                broken[num] = true;
            }
        }

        int result = Math.abs(n - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();
            boolean ck = false;
            for (int j = 0; j < len; j++) { // i에 고장난 버튼이 있는지 확인
                if (broken[str.charAt(j) - '0']) {
                    ck = true;
                    break;
                }
            }
            if (!ck) { // i로 이동하는데에 고장난 버튼이 없다
                int tmp = len + Math.abs(n - i); // i누른 후 + i에서 n으로 이동
                result = Math.min(tmp, result);
            }
        }
        System.out.println(result);
    }
}