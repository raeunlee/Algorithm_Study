import java.io.*;
import java.util.*;

public class Main {
    static long C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(func(A, B));
    }

    public static long func(long A, long B) { // A = 밑, B = 지수
        if (B == 1) {
            return A % C;
        }
        long n = func(A, B / 2);
        if (B % 2 == 1) { // 지수가 홀수라면
            return n * n % C * A % C;
        }
        return n * n % C;
    }
}