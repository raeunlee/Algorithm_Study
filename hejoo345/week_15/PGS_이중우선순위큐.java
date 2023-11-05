import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> asc = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        StringTokenizer st;
        for (String s : operations) {
            st = new StringTokenizer(s);
            String op = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            System.out.println(op + " " + num);
            switch (op) {
                case "I": // 큐에 숫자 삽입
                    asc.add(num);
                    desc.add(num);
                    break;
                case "D":
                    if (asc.isEmpty()) break;
                    if (num == 1) { // 최댓값 삭제
                        int max = desc.poll();
                        asc.remove(max);
                    } else { // 최솟값 삭제
                        int min = asc.poll();
                        desc.remove(min);
                    }
            }
        }
        if (asc.isEmpty()) return new int[]{0, 0};
        else return new int[]{desc.peek(), asc.peek()};
    }
}