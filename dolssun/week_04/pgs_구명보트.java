package week04;

import java.util.*;

class pgs_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int min = 0;
        
        for(int max = people.length-1; max>=min; max--){
            if(people[min]+people[max] <= limit)
                min++;
            answer++;
        }
        
        return answer;
    }
}