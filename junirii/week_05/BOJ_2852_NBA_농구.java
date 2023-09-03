import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] answerArr = new int[3];
		int[] scoreArr = new int[3];
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int team = Integer.parseInt(st.nextToken());
		scoreArr[team]++;
		String time = st.nextToken();
		String[] timeArr = time.split(":");
		int minute = Integer.parseInt(timeArr[0]);
		int second = Integer.parseInt(timeArr[1]);
		int time_sec = minute*60 + second;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(sc.nextLine());
			team = Integer.parseInt(st.nextToken());
			time = st.nextToken();
			timeArr = time.split(":");
			minute = Integer.parseInt(timeArr[0]);
			second = Integer.parseInt(timeArr[1]);
			int time_sec_tmp = minute*60 + second;
			int win_team = 0;
			if(scoreArr[1] > scoreArr[2])
				win_team = 1;
			else if(scoreArr[2] > scoreArr[1])
				win_team = 2;
			
			if(win_team > 0) answerArr[win_team] += time_sec_tmp - time_sec;
			scoreArr[team]++;
			time_sec = time_sec_tmp;
		}
		if(scoreArr[1] > scoreArr[2]) 
			answerArr[1] += (48*60 - time_sec);
		else if(scoreArr[1] < scoreArr[2])
			answerArr[2] += (48*60 - time_sec);
		
		System.out.println(String.format("%02d", answerArr[1]/60)+":"+String.format("%02d", answerArr[1]%60));
		System.out.println(String.format("%02d", answerArr[2]/60)+":"+String.format("%02d", answerArr[2]%60));
	}
}
