package week05;

import java.util.*;

class boj_1157{
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_1 = -1;
        int max_2 = -1;
        
        for(int i=0; i<sizes.length; i++){
            Arrays.sort(sizes[i]);
            
            if(sizes[i][0] > max_1){
                max_1 = sizes[i][0];
            }
            if(sizes[i][1] > max_2){
                max_2 = sizes[i][1];
            }
            
        }
        
        answer = max_1*max_2;
        
        
        return answer;
    }
}