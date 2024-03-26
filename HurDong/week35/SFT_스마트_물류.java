import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        String s = sc.next();

        char[] places = new char[n]; // 로봇과 부품을 저장 만약 부품을 사용했으면 H를 X로 변경

        for(int i=0;i<n;i++)
            {
                places[i] = s.charAt(i);
            }

        int count =0;
        
        for(int i=0;i<n;i++)
            {
                // 로봇에 대하여
                if(places[i]=='P'){
                    for(int j=i-k;j<=i+k;j++)
                        {
                            // 인덱스를 벗어나지 않으면서
                            if(j>=0 && j<n){
                                // 부품일 경우(가장 좌측부터)
                                if(places[j] == 'H'){
                                    // 사용한 X로 수정 후
                                    places[j] = 'X';
                                    // 정답을 증가
                                    count++;
                                    // break하여 가장 좌측만 접근
                                    break;
                                }
                            }
                        }
                    
                }
            }
        System.out.println(count);
    }
}
