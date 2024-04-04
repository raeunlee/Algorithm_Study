import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;
    static int n,m;
    static int[] weights;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = sc.nextInt();

        weights = new int[n+1];

        for(int i=1;i<=n;i++)
            {
                weights[i] = sc.nextInt();
            }
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++)
            {
                graph.add(new ArrayList<>());
            }
        
        for(int i=0;i<m;i++)
            {
                int a = sc.nextInt();

                int b = sc.nextInt();

                graph.get(a).add(b);
                
                graph.get(b).add(a);
            }
        
        int count =0;
        
        for(int i=1;i<=n;i++){
            int weight = weights[i];
            
            List<Integer> list = graph.get(i);
            
            boolean isBig = true;
            
            for(int j=0;j<list.size();j++)
                {
                    if(weight <= weights[list.get(j)]){
                        isBig = false;
                    }
                }
            if(isBig) 
                {
                    count++;
                }
        }
        
        System.out.println(count);
        
    }
}
