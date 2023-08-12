import java.util.*;
class Solution {
    static int[] answer;
    static int[] result;
    public int[] solution(String s) {    
        int[] answer = new int[2];       
        answer = recur(s, 0, 0);
        return answer;
    }
    public int[] recur(String string, int dropzero, int count){
        result = new int[2];
        StringBuilder sb = new StringBuilder();
        // 1. arr에 x의 모든 0을 제거한것을 수행
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i)=='1') { // 1이면?
                sb.append('1'); // 문자열에 추가
            }
            else{ dropzero ++; // 아니면 추가하지말고 버리는 0 카운트에 추가 
            }
        }
        // 2. x의 길이를 c, "c를 2진법으로 표현한 문자열"로 바꾼다
        int c = sb.length(); // c를 2진법으로 표현하기
        String binary = Integer.toBinaryString(c);
        count ++;
        if(binary.length() > 1) {
            recur(binary, dropzero, count);
        }
        else{
            result[0] = count;
            result[1] = dropzero;   
        }
        return result;
    }
}