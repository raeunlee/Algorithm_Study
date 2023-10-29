import java.util.*;

class Solution {
    static int[] parent;

    public int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 < p2) {
            parent[p2] = p1;
        } else {
            parent[p1] = p2;
        }
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) { // 부모 배열 초기화
            parent[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> { // 비용이 작은 순으로 정렬
            return o1[2] - o2[2];
        });

        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) { // 부모가 다르다면
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }
}