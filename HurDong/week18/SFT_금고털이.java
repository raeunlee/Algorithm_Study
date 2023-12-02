import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int w = sc.nextInt();
      int n = sc.nextInt();
      
      int[] weights = new int[n+1];
      int[] prices = new int[n+1];

      // prices를 기준으로 내림차순 정렬
      PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
          return o2[1] - o1[1];
        }
      });
      
      for(int i=1;i<=n;i++)
        {
          weights[i] = sc.nextInt();
          prices[i] =sc.nextInt();
          queue.add(new int[]{weights[i],prices[i]});
          
        }
      int sum = 0;
      while(w>0){
        if(!queue.isEmpty()){
          int[] item = queue.poll();
          int weight = item[0], price = item[1];
          if(w>weight){
            sum+=weight * price;
          }else{
            sum+= w * price;
          }
            w-=weight;
        }
      }
      System.out.println(sum);
      
      
      
      
    }
}
