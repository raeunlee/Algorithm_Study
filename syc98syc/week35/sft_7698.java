import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] hubo = new int[T];
        for(int i=0; i<T; i++){
            hubo[i] = sc.nextInt();
        }

        for(int i=0; i<hubo.length; i++){
            open(hubo[i]);
            System.out.println();
        }
    }
    
    static void open(int hubo){
        int p = hubo/5;
        int q = hubo%5;
    for(int i=0; i<p; i++){
        System.out.print("++++ ");
    }
    for(int i=0; i<q; i++){
        System.out.print("|");
    }
    }
}