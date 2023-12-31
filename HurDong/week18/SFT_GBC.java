import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      int m = sc.nextInt();
      
      int[][] gbc = new int[n][2];
      int[][] test = new int[m][2];
      
      for(int i=0;i<n;i++)
        {
          gbc[i][0] = sc.nextInt();
          gbc[i][1] = sc.nextInt();
        }
      
      for(int i=0;i<m;i++)
        {
          test[i][0] = sc.nextInt();
          test[i][1] = sc.nextInt();
        }
      
      int answer=0, gbcIdx =0, testIdx=0;
      while(test[m-1][0] > 0 ){
        // test와 gbc의 비교 후 작은 값으로 빼준 후 해당 배열의 인덱스 값 증가, 같을 경우 둘다 증가 후 해당 test를 0으로 만들어 while문 탈출 유도
        if(test[testIdx][0]>gbc[gbcIdx][0]){
          test[testIdx][0] = test[testIdx][0] - gbc[gbcIdx][0];
          answer = Math.max(answer,test[testIdx][1] - gbc[gbcIdx][1]);
          gbc[gbcIdx][0] = 0;
          gbcIdx++;
        }else if(test[testIdx][0]<gbc[gbcIdx][0]){
          gbc[gbcIdx][0] = gbc[gbcIdx][0] - test[testIdx][0];
          answer = Math.max(answer,test[testIdx][1] - gbc[gbcIdx][1]);
          test[testIdx][0] = 0; //  테스트가 더 길 경우의 케이스를 위한 0 초기화
          testIdx++;
        } else{
          answer = Math.max(answer,test[testIdx][1]-gbc[gbcIdx][1]);
          test[testIdx][0] = 0;
          testIdx++;
          gbcIdx++;
        }
      }
    System.out.println(answer);
    }
}
