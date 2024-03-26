import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 끝나는 시간으로 정렬하고 같으면 시작하는 시간 이른 순으로
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[][] classes = new int[n][2];
        for(int i=0;i<n;i++)
            {
                classes[i][0] = sc.nextInt();
                classes[i][1] = sc.nextInt();
            }
        // 정렬
        Arrays.sort(classes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[1]==b[1]){
                    return a[0]-b[0];
                } else{
                    return a[1] - b[1];
                }
            }
        });
        int idx = 0; // 현재 강의실을 쓰는 강의
        int time = classes[idx][1]; // 강의실이 끝나는 시간(다음 강의시작시간이하여야함)
        int count = 1; // 정답
        while(idx<n){
            idx++;
            if(idx==n){
                break;
            }
            // 지금 강의 끝 시간이 다음 강의 시작 시간이하일때
            if(classes[idx][0] >= time){
                count++;
                time = classes[idx][1];
            }
        }
        System.out.println(count);
        
    }
}
