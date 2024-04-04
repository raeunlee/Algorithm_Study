import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] DCT = new int[8];
        boolean asc = true;
        boolean des = true;
        String name = "ascending";
        DCT[0] = sc.nextInt();
        for(int i=1; i<8; i++){
            DCT[i] = sc.nextInt();
            if(DCT[i-1]<DCT[i]){
                des = false;
            }else if(DCT[i-1]>DCT[i]){
                asc = false;
            }
        }

        if(asc ==true){
            System.out.println("ascending");
        }else if(des ==true){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}
