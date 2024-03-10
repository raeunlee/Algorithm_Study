import java.util.*;
public class boj2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] height = new int[9];
		int sum=0;
		int ex1=100, ex2=100;
		int[] ans = new int[7];
		int index=0;
		
		for(int i=0; i<9; i++) {
			height[i]=sc.nextInt();
			sum+=height[i];
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(i!=j) {
					if(sum-height[i]-height[j]==100) {
						ex1=i;
						ex2=j;
						break;
					}
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if((i!=ex1) && (i!=ex2)) {
				ans[index++]=height[i];
			}
		}
		
		Arrays.sort(ans);
		for(int i=0; i<7; i++)
			System.out.println(ans[i]);	
	}
}
