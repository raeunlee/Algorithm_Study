import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] lands = new int[n];

        for(int i=0;i<n;i++)
            {
                lands[i] = sc.nextInt();
            }
        Arrays.sort(lands);

    int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++)
                {
                    max = Math.max(max, lands[i] * lands[j]);
                }
        }
        System.out.println(max);
    }
}
