class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int num = 1; // 현재 값
        int row = 0; // 현재 행
        int col = 0; // 현재 열
        int direction = 0; // 방향

        while (num <= n * n) {
            answer[row][col] = num;
            num++;

            if (direction == 0) { // 오른쪽으로 이동
                if (col == n - 1 || answer[row][col + 1] != 0) {
                    direction = 1;
                    row++;
                } else {
                    col++;
                }
            } else if (direction == 1) { // 아래로 이동
                if (row == n - 1 || answer[row + 1][col] != 0) {
                    direction = 2;
                    col--;
                } else {
                    row++;
                }
            } else if (direction == 2) { // 왼쪽으로 이동
                if (col == 0 || answer[row][col - 1] != 0) {
                    direction = 3;
                    row--;
                } else {
                    col--;
                }
            } else if (direction == 3) { // 위로 이동
                if (row == 0 || answer[row - 1][col] != 0) {
                    direction = 0;
                    col++;
                } else {
                    row--;
                }
            }
        }
        return answer;
    }
}