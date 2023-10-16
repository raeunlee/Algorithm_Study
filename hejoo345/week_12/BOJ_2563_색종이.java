import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        arr = new int[101][101];
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 왼쪽 변 사이 거리
            int m = Integer.parseInt(st.nextToken()); // 아래쪽 변 사이 거리

            for (int i = m; i < m + 10; i++) {
                for (int j = n; j < n + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(arr[i][j] == 1) ans++;
            }
        }
        System.out.println(ans);
    }
}