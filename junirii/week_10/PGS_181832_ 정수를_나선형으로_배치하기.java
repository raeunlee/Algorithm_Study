class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int dir = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n*n; i++) {
        	answer[y][x] = i;
			switch(dir) {
				case 0: // 오른쪽
					if(x+1 >= n || answer[y][x+1] > 0) {
						dir++;
						y++;
					}else {
						x++;
					}
					break;
				case 1: // 아래쪽
					if(y+1 >= n || answer[y+1][x] > 0) {
						x--;
						dir++;
					}else {
						y++;
					}
					break;
				case 2: // 왼쪽
					if(x-1 < 0 || answer[y][x-1] > 0) {
						dir++;
						y--;
					}else {
						x--;
					}
					break;
				case 3: // 위쪽
					if(y-1 < 0 || answer[y-1][x] > 0) {
						dir = 0;
						x++;
					}else {
						y--;
					}
					break;
			}
		}
        
        return answer;
    }
}
