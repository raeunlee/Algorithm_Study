package week05;

// 프로그래머스 : H-Index

import java.util.*;

class pgs_H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        int len = citations.length;
        for(int i=0; i<len; i++){
            if(len-i <= citations[i]){
                answer = len-i;
                break;
            }
        }



        return answer;
    }
}