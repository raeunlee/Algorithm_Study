import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = n;
        int rcnt = 0;
        int bcnt = 0;

        // 공 개수 세기
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                rcnt++;
            } else {
                bcnt++;
            }
        }

        // 4가지 경우
        // 1. R을 모두 왼쪽으로
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        result = Math.min(result, rcnt - cnt);

        // 2. R을 모두 오른쪽으로
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'R') {
                cnt++;
            } else {
                break;
            }
        }
        result = Math.min(result, rcnt - cnt);

        // 3. B를 모두 왼쪽으로
        cnt = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        result = Math.min(result, bcnt - cnt);

        // 4. B을 모두 오른쪽으로
        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (str.charAt(i) == 'B') {
                cnt++;
            } else {
                break;
            }
        }
        result = Math.min(result, bcnt - cnt);
        System.out.println(result);
    }

}