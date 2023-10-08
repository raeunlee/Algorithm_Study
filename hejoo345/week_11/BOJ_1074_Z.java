import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열
        int size = (int) Math.pow(2, n);

        find(r, c, size);
        System.out.println(answer);
    }

    public static void find(int r, int c, int size) {
        if (size == 1) {
            return;
        }
        if (r < size / 2 && c < size / 2) { // 1사분면
            find(r, c, size / 2);
        } else if (r < size / 2 && c >= size / 2) { // 2사분면
            answer += size * size / 4;
            find(r, c - size / 2, size / 2);
        } else if (r >= size / 2 && c < size / 2) { // 3사분면
            answer += (size * size / 4) * 2;
            find(r - size / 2, c, size / 2);
        } else { // 4사분면
            answer += (size * size / 4) * 3;
            find(r - size / 2, c - size / 2, size / 2);
        }
    }
}