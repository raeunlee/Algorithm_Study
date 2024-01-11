import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()); // 행 개수
        int c = Integer.parseInt(st.nextToken()); // 열 개
        char[][] puzzle = new char[r][c];

        for (int i = 0; i < r; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < c; j++) {
                puzzle[i][j] = tmp.charAt(j);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        // 가로(좌 -> 우)
        for (int i = 0; i < r; i++) {
            String tmp = "";
            int length = 0;
            for (int j = 0; j < c; j++) {
                if (puzzle[i][j] == '#') {
                    if (length >= 2) {
                        list.add(tmp);
                    }
                    tmp = "";
                    length = 0;
                } else {
                    tmp += puzzle[i][j];
                    length++;
                }
            }
            if (length >= 2) {
                list.add(tmp);
            }
        }

        // 세로(상 -> 하)
        for (int i = 0; i < c; i++) {
            String tmp = "";
            int length = 0;
            for (int j = 0; j < r; j++) {
                if (puzzle[j][i] == '#') {
                    if (length >= 2) {
                        list.add(tmp);
                    }
                    tmp = "";
                    length = 0;
                } else {
                    tmp += puzzle[j][i];
                    length++;
                }
            }
            if (length >= 2) {
                list.add(tmp);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}