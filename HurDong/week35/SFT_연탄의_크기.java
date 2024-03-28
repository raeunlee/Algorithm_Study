import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] briquet;
    static List<Integer> comb;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) {
        // 항상 1보다 큼
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        briquet = new int[n];

        visited = new boolean[n];
        
        for(int i=0;i<n;i++)
            {
                briquet[i] = sc.nextInt();
            }

        Arrays.sort(briquet);
        
        findAnswer();
        
        System.out.println(answer);        
    }
    public static void findAnswer(){
        Map<Integer,Integer> map = new HashMap<>(); // 약수들의 빈도수를 체크
        for(int num : briquet){
            for(int i=2;i<=num;i++)
                {
                    if(num%i==0){
                      // 약수라면map에 해당 약수 value를 높이는데 없으면 0으로 get하고 1추가
                        map.put(i,map.getOrDefault(i,0)+1);
                    }        
                }
        }
        for(int houses : map.values()){
            answer = Math.max(answer,houses);
        }
    }
}
