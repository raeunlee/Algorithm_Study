import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = Integer.parseInt(br.readLine()); // 스위치 개수
        arr = new int[101];
        st = new StringTokenizer(br.readLine());
        for (int s = 1; s <= cnt; s++) {
            arr[s] = Integer.parseInt(st.nextToken());
        }
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 성별 남 1 여 2
            int m = Integer.parseInt(st.nextToken()); // 학생이 받은 수

            if (n == 1) { // 남학생
                for (int i = 1; i <= cnt; i++) {
                    if (i % m == 0) { // 받은 수의 배수이면 상태 바꿈
                        arr[i] = arr[i] == 0 ? 1 : 0;
                    }
                }
            } else { // 여학생
                arr[m] = arr[m] == 0 ? 1 : 0;
                int pivot = 1;
                while (true) {
                    if (m - pivot < 1 || m + pivot > cnt) {
                        break;
                    }
                    if (arr[m + pivot] == arr[m - pivot]) { // 대칭일 때
                        arr[m + pivot] = arr[m + pivot] == 0 ? 1 : 0;
                        arr[m - pivot] = arr[m - pivot] == 0 ? 1 : 0;
                    } else { // 대칭이 아닐 때
                        break;
                    }
                    pivot++;
                }
            }
        }
        for (int i = 1; i <= cnt; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}