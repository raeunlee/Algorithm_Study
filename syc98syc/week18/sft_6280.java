import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
      Scanner scan= new Scanner(System.in);
      int n = scan.nextInt();
      int dot=2;

      for(int i=0;i<n;i++){
        dot+=dot-1;
      }
        
      System.out.print(dot*dot);
    }
}
