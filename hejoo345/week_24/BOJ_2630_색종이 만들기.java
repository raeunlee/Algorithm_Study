import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static int white;
    static int blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        white = 0;
        blue = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        partition(0, 0, n);

        StringBuilder sb = new StringBuilder();
        sb.append(white).append("\n").append(blue);
        System.out.println(sb);
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (arr[row][col] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        // 나누어진 종이가 다 같은 색상이 아닐 때 다시 4등분
        int newSize = size / 2;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int color = arr[row][col]; // 첫번째 색상을 비교 대상으로 삼음
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != arr[i][j]) { // 비교 대상과 다른 색상이라면
                    return false;
                }
            }
        }
        return true;
    }
}