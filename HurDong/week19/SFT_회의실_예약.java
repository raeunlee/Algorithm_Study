import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      StringBuilder sb = new StringBuilder();
      int n = sc.nextInt();
      int m = sc.nextInt();
      Map<String,int[]> rooms = new TreeMap<>();
      String[] rList = new String[n];
      for(int i =0;i<n;i++)
        {
          //9~18 이므로 9부터 17까지 배열생성
          String s = sc.next();
          int[] arr = new int[9];
          rooms.put(s,arr);
          rList[i] = s;
        }
      Arrays.sort(rList);
      for(int i=0;i<m;i++)
        {
          String s = sc.next();
          int start = sc.nextInt()-9;
          int end = sc.nextInt()-9;
          int[] arr = rooms.get(s);
          for(int j=start;j<end;j++)
            {
              arr[j] = 1;
            }
          rooms.put(s,arr);
        }
      for(int i=0;i<rooms.size();i++)
        {
          int[] arr = rooms.get(rList[i]);
          System.out.println("Room " + rList[i] + ":");
          if(numAvailable(arr)==0) {
            System.out.println("Not available");
          }
          else {
            System.out.println(numAvailable(arr) + " available:");
            boolean seq = false;
            for(int j=0;j<arr.length;j++)
              {
                if(seq && arr[j]==0){
                  if(j==arr.length-1){
                    System.out.println("18");
                  }
                }
                if(seq&&arr[j]==1){
                  seq = false;
                  System.out.println(j+9);
                }
                if(!seq&&arr[j]==0){
                  if(j==arr.length-1){
                    System.out.println("17-18");
                  }
                  else{
                    if(j==0){
                      System.out.print("09-");
                      seq=true;
                    }
                    else{
                      System.out.print(j+9 +"-");
                      seq =true;
                    }
                  }
                }
              }
          }
          if(i==rooms.size()-1) break;
          System.out.println("-----");
        }
      
    }
 public static int numAvailable(int[] arr){
   int count =0;
   boolean seq = false;
   for(int i=0;i<arr.length;i++)
     {
       if(arr[i]==0){
         if(!seq){
           seq = true;
         }
         if(i==arr.length-1){
           count++;
         }
       }
       else{
         if(seq){
           seq = false;
           count++;
         }
       }
     }
    return count;   
 }   
}
