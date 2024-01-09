import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class boj2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum=0;
		int max,min;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<Integer> modeArr = new ArrayList<>();
		
		int arithmeticMean; //산술평균
		int median; //중앙값
		int mode; //최빈값
		int scope; //범위
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			sum+=arr[i];
			int count=0;
			if(map.containsKey(arr[i])!=false)
				count= map.get(arr[i]);
			map.put(arr[i], count+1);
		}
		
		//산술평균
		arithmeticMean=(int) Math.round((double)sum/N);
		
		//중앙값
		Arrays.sort(arr);
		median=arr[N/2];
		
		//최빈값
		int maxValue = Collections.max(map.values());
		for(Map.Entry<Integer,Integer> m: map.entrySet()) {
			if(m.getValue()==maxValue) {
				modeArr.add(m.getKey());
			}
		}
		
		Collections.sort(modeArr);
		mode=modeArr.get(0);
		if(modeArr.size()>=2)
			mode=modeArr.get(1);
		
		//범위
		min=arr[0];
		max=arr[N-1];
		scope=max-min;

		System.out.println(arithmeticMean);
		System.out.println(median);
		System.out.println(mode);
		System.out.println(scope);
	}

}
