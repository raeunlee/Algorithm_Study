import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                int now = arr[i]*arr[j];
                if(max<now)
                    max=now;
            }
        }
        System.out.println(max);
        
    }
}
