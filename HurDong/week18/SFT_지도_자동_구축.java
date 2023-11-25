import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      // 2n-1
      // 2 3 5 9 17
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] dp = new int[n+1];
      dp[1] = 3;
      for(int i=2;i<=n;i++)
        {
          dp[i] = dp[i-1] * 2 - 1;
        }
      System.out.println((int)Math.pow(dp[n],2));
    }
}
