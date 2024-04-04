import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] speed = new int[8];

        for(int i=0;i<8;i++)
            {
                speed[i] = sc.nextInt();
            }
        
        boolean isMixed = false; // mixed인지 아닌지
        
        boolean isUp = false; // asc인지 des인지
        
        if(speed[0]==1){
            isUp = true; // asc
            for(int i=1;i<8;i++)
                {
                    if(speed[i] != i+1){
                        isMixed = true;
                        break;
                    }
                }
        } else if(speed[0]==8)
            {
                isUp  = false; // des
                for(int i=1;i<8;i++)
                    {
                        if(speed[i] != 8-i){
                            isMixed= true;
                            break;
                        }
                    }
            } else{
                isMixed = true; // mixed
            }
        
        if(isMixed) {
                System.out.println("mixed");
        } else{
            System.out.println(isUp ? "ascending" : "descending");
        }
    }
}
