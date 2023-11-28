import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] score = new int[n];
      for(int i=0;i<n;i++)
        {
          score[i] = sc.nextInt();
        }
      int[] dp = new int[n];
      dp[0]=score[0];
      for(int i=1;i<n;i++)
        {
          dp[i]= dp[i-1] + score[i];
        }
      while(k-->0){
        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;
        int sum =0;
        if(a==0){
          sum = dp[b];
        }else{
          sum = dp[b]-dp[a-1];
        }
        double result = (double)sum/(b-a+1);
        System.out.printf("%.2f\n",result);
      }
    }  
}
