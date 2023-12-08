import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, k) - 1; // 노드의 개수 2^k - 1
        arr = new int[n];

        // 입력값 arr에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 노드 저장하기 위한 list
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        // 탐색 시작
        search(0, n - 1, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void search(int start, int end, int depth) {
        if (depth == k) return;

        int mid = (start + end) / 2;
        list.get(depth).add(arr[mid]);

        // 왼쪽 노드 탐색
        search(start, mid - 1, depth + 1);
        // 오른쪽 노드 탐색
        search(mid + 1, end, depth + 1);
    }
}