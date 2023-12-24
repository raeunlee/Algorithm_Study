import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Road {
    int end;
    int weight;

    Road(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int N, M, W;
    static int[] dist;
    static ArrayList<ArrayList<Road>> a;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 지점의 수
            M = Integer.parseInt(st.nextToken()); // 도로의 개수
            W = Integer.parseInt(st.nextToken()); // 웜홀의 개수

            dist = new int[N + 1];
            a = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                a.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                if (i < M) { // 도로는 양방향 그래프
                    a.get(start).add(new Road(end, weight));
                    a.get(end).add(new Road(start, weight));
                } else { // 웜홀은 단방향 그래프
                    a.get(start).add(new Road(end, -weight));
                }
            }

            boolean isMinusCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    isMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            if (!isMinusCycle) {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 벮만포드 알고리즘
    public static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0; // 시작점 0으로 초기화
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단거리 초기화
            for (int j = 1; j <= N; j++) {
                for (Road road : a.get(j)) {
                    if (dist[j] != INF && dist[road.end] > dist[j] + road.weight) {
                        dist[road.end] = dist[j] + road.weight;
                        update = true;
                    }
                }
            }
            // 더 이상 최단거리 초기화가 일어나지 않았을 때 반복문 종료
            if (!update) {
                break;
            }
        }
        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미
        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Road road : a.get(i)) {
                    if (dist[i] != INF && dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}