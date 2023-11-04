import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int cnt = 0; // 100%까지 걸리는 날
            int pro = progresses[i];
            for (; ; ) {
                if (pro >= 100) break;
                pro += speeds[i];
                cnt++;
            }
            queue.add(cnt);
        }

        int[] arr = new int[100];
        int idx = 0;
        int day = 1; // 총 며칠 걸리는지
        // System.out.println(queue);
        int curr = queue.poll(); // 비교 대상
        for (int i : queue) {
            if (i > curr) {
                day++;
                curr = i;
                idx++;
            } else {
                arr[idx]++;
            }
        }
        int[] answer = new int[day];
        for (int i = 0; i < day; i++) {
            answer[i] = arr[i] + 1;
        }
        return answer;
    }
}