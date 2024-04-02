import java.io.*;
import java.util.*;

public class Main {
    static boolean[] memberIsBest; //본인이최고

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //회원수
        int M = Integer.parseInt(st.nextToken()); //관계수
        int[] weight = new int[N]; //각자무게
        
        memberIsBest = new boolean[N];
        for(int i=0; i<N; i++) {
        	memberIsBest[i] =true; //초기화
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
        	weight[i] = Integer.parseInt(st.nextToken());
        }
    
        for(int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	whoIsBest(a, b, weight[a-1], weight[b-1]);
        }
        
        int count=0;
        for(int i=0; i<N; i++) {
        	if(memberIsBest[i]==true)
        		count++;
        }
        
        System.out.println(count);
    }

	private static void whoIsBest(int a, int b, int aW, int bW) {
		if(aW>=bW) memberIsBest[b-1]=false;
		if(bW>=aW) memberIsBest[a-1]=false;
	}
}