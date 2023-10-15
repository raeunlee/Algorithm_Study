import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서

            st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>(); // 문서 중요도
            Queue<Integer> idxQueue = new LinkedList<>(); // 문서 인덱스
            for (int d = 0; d < n; d++) {
                queue.add(Integer.parseInt(st.nextToken()));
                idxQueue.add(d);
            }
            int cnt = 0;
            while (true) {
                int tmp = queue.poll(); // 현재 문서
                int idx = idxQueue.poll(); // 현재 인덱스
                boolean ck = false;
                for (int doc : queue) {
                    if (tmp < doc) { // 중요도가 더 큰게 있으면 맨 뒤에 넣어줌
                        queue.add(tmp);
                        idxQueue.add(idx);
                        ck = true;
                        break;
                    }
                }
                if (!ck) {
                    cnt++;
                    if (idx == m) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}