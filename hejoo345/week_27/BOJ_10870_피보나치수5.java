import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}