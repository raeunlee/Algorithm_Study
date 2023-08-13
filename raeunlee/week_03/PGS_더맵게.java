import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();        
        //우선순위 큐로 작은 수 부터 정렬해준다
        for(int i = 0; i < scoville.length; i++){
            queue.add(scoville[i]);
        }
        //맨앞자리를 peek로 확인해서 k보다 작다면 연산을 해주고 다시 넣어준다
        for(int i = 0; i < scoville.length; i ++) {
            if(queue.peek() < K) { //맨 앞자리가 K보다 작다면?
              queue.add(queue.poll() + queue.poll()*2);
                answer += 1;
            }
        }
    
      return answer;
    }
    
  
}