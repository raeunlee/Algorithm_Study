import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++)
        {
            int n = sc.nextInt();
            int div = n/5;
            int rem = n%5;
            for(int j=0;j<div;j++)
                {
                    sb.append("++++ ");
                }
            for(int j=0;j<rem;j++)
                {
                    sb.append("|");
                }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}
