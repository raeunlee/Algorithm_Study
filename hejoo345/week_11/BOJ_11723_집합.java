import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력할 문자열
        StringTokenizer st;
        int M = Integer.parseInt(br.readLine()); // 연산의 수
        int num;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String calc = st.nextToken();
            switch (calc) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    if (!set.contains(num)) {
                        set.add(num);
                    }
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    }
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}