package week05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2852 : NBA 농구

public class boj_2852 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int win = -1;
		int sec;
		int[] score = {0,0};
		int[] w_time = {0,0};
		Record[] records = new Record[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			win = Integer.parseInt(st.nextToken());
			String[] time = st.nextToken().split(":");
			sec = Integer.parseInt(time[0])*60+ Integer.parseInt(time[1]);
			records[i] = new Record(win, sec);
		}
		
		win = records[0].team;
		score[win-1] += 1;
		sec = records[0].time;
		
		for(int i=1; i<n; i++) {
			int tmp_team = records[i].team;
			int tmp_time = records[i].time;
			
			if(score[0]>score[1]) {
				w_time[0] += (tmp_time - sec);
			}
			if(score[0]<score[1]) {
				w_time[1] += (tmp_time - sec);
			}
			score[tmp_team-1] += 1;
			
			sec = tmp_time;
			
		}
		
		if (score[0] > score[1]) {
			w_time[0] += (48 * 60 - sec);
        }
        if (score[0] < score[1]) {
        	w_time[1] += (48 * 60 - sec);
        }
        
        for (int i = 0; i < 2; i++) {
            int h = w_time[i] / 60;
            int m = w_time[i] % 60;
            String hour;
            String min;
            if (h < 10) {
                hour = "0" + Integer.toString(h);
            }else {
                hour = Integer.toString(h);
            }

            if (m < 10) {
                min = "0" + Integer.toString(m);
            }else {
                min = Integer.toString(m);
            }

            System.out.println(hour + ":" + min);

        }
		
	}
	
}
class Record{
	int team,time;
	
	public Record(int team, int time) {
		this.team = team;
		this.time = time;
	}
}
