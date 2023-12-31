import java.io.*;
import java.util.*;

public class Main {
    static final long mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      
        long k = sc.nextLong(); // 바이러스 초기 개수
      
        long p = sc.nextLong(); // 증가 배율
      
        long n = sc.nextLong(); // 시간(초)
      
        n *=10;
      
        k = ( k * superVirus(p,n))%mod;

        System.out.println(k);
    }
    public static long superVirus(long base , long power){
      long result = 1;
      base %= mod;
      while(power>0){
        if(power%2==1){
          result=(result*base)%mod;
        }
        base = (base * base) % mod;
        power /= 2;
      }
      return result;
    }
}


