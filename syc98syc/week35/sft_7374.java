import java.io.*;
import java.util.*;

public class Main {
    static int min;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        min = 6;

        for(int i=0; i<9; i+=3){
            String[] s = sc.nextLine().split(" ");
            arr[i] = Integer.parseInt(s[0]);
            arr[i+1] = Integer.parseInt(s[1]);
            arr[i+2] = Integer.parseInt(s[2]);
        }

        grid(arr,1);
        grid(arr,2);
        grid(arr,3);

        System.out.println(min);
    }

    static void grid(int[] arr, int height){
        //가로
        for(int i=0; i<9; i+=3) {
        	int a = Math.abs(arr[i]-height);
        	int b = Math.abs(arr[i+1]-height);
        	int c = Math.abs(arr[i+2]-height);
        	min = Integer.min(min, a+b+c);
        }
        //세로
        for(int i=0; i<3; i++) {
        	int a = Math.abs(arr[i]-height);
        	int b = Math.abs(arr[i+3]-height);
        	int c = Math.abs(arr[i+6]-height);
        	min = Integer.min(min, a+b+c);
        }
    }
}