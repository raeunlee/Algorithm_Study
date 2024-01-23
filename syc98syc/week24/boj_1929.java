import java.util.Scanner;
public class boj_1929_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] isPrime = new boolean[N+1];
		
		isPrime[0]=false;
		isPrime[1]=false;
		
		for(int i=2; i<=N; i++) {
			isPrime[i]=true;
		}
		
		for(int i=2; i<=Math.sqrt(N); i++) {
			if(isPrime[i]) {
				for(int j=i*i; j<=N; j+=i)
					isPrime[j]=false;
			}
		}
		
		for(int i=M; i<=N; i++) {
			if(isPrime[i])
				System.out.println(i);
		}
		
	}

}
