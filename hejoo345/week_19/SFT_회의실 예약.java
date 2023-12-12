import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, int[][]> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int[][] tmp = new int[9][2];
            for (int j = 0; j < 9; j++) {
                tmp[j][0] = j;
                tmp[j][1] = j + 1;
            }
            map.put(br.readLine(), tmp);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String room = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[][] cur = map.get(room);
            for (int j = start; j < end; j++) { // 회의가 있는 시간은 -1을 넣음
                cur[j - 9][0] = -1;
                cur[j - 9][1] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, int[][]> entry : map.entrySet()) {
            sb.append("Room ").append(entry.getKey()).append(":").append("\n");
            StringBuilder tmp = new StringBuilder();
            int[][] cur = entry.getValue();
            int total = 0;
            int start = -1;
            int end = -1;
            for (int i = 0; i < 9; i++) {
                if (cur[i][0] != -1) { // 예약 가능
                    if (start == -1) { // 시작점 안정해졌을 때
                        start = cur[i][0];
                    }
                } else { // 예약 불가능
                    if (start != -1) { // 시작점 정해졌을 때 end 구하기
                        end = cur[i - 1][1];
                    }
                }

                if (start != -1 && end != -1) {
                    tmp.append(start == 0 ? "09" : start + 9).append("-");
                    tmp.append(end + 9).append("\n");
                    start = -1;
                    end = -1;
                    total++;
                }
            }

            if (start != -1) {
                total++;
                tmp.append(start == 0 ? "09" : start + 9).append("-").append(18).append("\n");
            }

            if (total == 0) { // 예약 가능한 시간이 없을 때
                sb.append("Not available").append("\n");
            } else {
                sb.append(total).append(" available:").append("\n");
                sb.append(tmp);
            }

            sb.append("-----").append("\n");
        }
        sb.setLength(sb.length() - 6);
        System.out.println(sb);
    }
}