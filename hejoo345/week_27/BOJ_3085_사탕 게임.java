import java.io.*;
import java.util.*;

public class Main {
    static char[][] arr;
    static int max;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        max = 1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        // 좌우 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(i, j, i, j + 1);
                search();
                swap(i, j, i, j + 1);
            }
        }

        // 상하 바꾸기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                swap(j, i, j + 1, i);
                search();
                swap(j, i, j + 1, i);
            }
        }
        System.out.println(max);
    }

    public static void swap(int y1, int x1, int y2, int x2) {
        char tmp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = tmp;

    }

    public static void search() {
        // 같은 행에서 가장 긴 연속 부분
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        // 같은 열에서 가장 긴 연속 부분
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}