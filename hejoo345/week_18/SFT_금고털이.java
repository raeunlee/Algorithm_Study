import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort((o1, o2) -> {
            return o2[1] - o1[1];
        });

        int answer = 0;s
        for (int i = 0; i < list.size(); i++) {
            if (w <= list.get(i)[0]) {
                answer += w * list.get(i)[1];
                break;
            } else {
                w -= list.get(i)[0];
                answer += list.get(i)[0] * list.get(i)[1];
            }
        }
        System.out.println(answer);
    }
}