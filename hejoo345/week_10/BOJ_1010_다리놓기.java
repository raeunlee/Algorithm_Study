import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 서쪽 n개 사이트
            int m = Integer.parseInt(st.nextToken()); // 동쪽 m개 사이트

            int answer = 1;
            for (int i = 0; i < n; i++) {
                answer *= m - i;
                answer /= 1 + i;
            }
            System.out.println(answer);
        }

    }
}