import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; // 순서
        Queue<Integer> queue = new LinkedList<>(); // 중요도 큐
        Queue<Integer> idxqueue = new LinkedList<>(); // 인덱스 큐
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
            idxqueue.add(i);
        }
        while (!queue.isEmpty()) {
            int peek = queue.peek();
            boolean ck = false;
            for (int n : queue) {
                if (n > peek) { // 우선순위가 더 큰 프로세스가 있다면
                    ck = true;
                    break;
                }
            }
            int tmp = queue.poll(); // 중요도 큐 맨 앞의 값 뽑기
            int idx = idxqueue.poll(); // 인덱스 큐 맨 앞의 값 뽑기
            if (ck) {
                queue.add(tmp);
                idxqueue.add(idx);
            } else {
                answer++;
                if (idx == location) {
                    break;
                }
            }
        }
        return answer;
    }
}