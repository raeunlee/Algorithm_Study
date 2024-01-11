import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long k = Long.parseLong(st.nextToken()); // 바이러스 수
        long p = Long.parseLong(st.nextToken()); // 증가율
        long n = Long.parseLong(st.nextToken()); // 총 시간
        n *= 10;

        long answer = recursion(p, n);

        System.out.println(k * answer % 1000000007);
    }

    public static long recursion(long p, long n) {
        if (n == 1) return p;

        long cur = recursion(p, n / 2);
        if (n % 2 == 1) {
            return (cur * cur % 1000000007) * p % 1000000007;
        } else {
            return cur * cur % 1000000007;
        }
    }
}