import java.io.*;
import java.util.*;

/*
 * 1 1 3
 * 1 1 3
 * 3 3 1
 */
public class Main {
	static int cost = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[3][3];
		visited = new boolean[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		if (checkBoard()) {
			System.out.println(0);
			return;
		} else {
			dfs(0, 0, 0);
		}
		System.out.println(cost);
	}

	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void dfs(int x, int y, int count) {
		if (checkBoard()) {
			cost = Math.min(cost, count);
//			printBoard();
			return;
		}

		if (y == 3)
			return;

		int nextX = (x + 1) % 3;
		int nextY = (nextX == 0) ? y + 1 : y;

		for (int i = 1; i <= 3; i++) {
			int temp = board[x][y];
			board[x][y] = i;
			if (temp == i) {
				dfs(nextX, nextY, count);
			} else {
				dfs(nextX, nextY, count + Math.abs(temp - i));
			}
//			System.out.println(Math.abs(temp - i));
			board[x][y] = temp;
		}
	}

	public static boolean checkBoard() {
		for (int i = 0; i < 3; i++) {
			int target1 = board[i][0];
			int target2 = board[0][i];
			boolean rSame = true;
			boolean cSame = true;
			for (int j = 1; j < 3; j++) {
				if (target1 != board[i][j]) {
					rSame = false;
				}
				if (target2 != board[j][i]) {
					cSame = false;
				}
			}
			if (rSame)
				return true;
			if (cSame)
				return true;
		}
		return false;
	}
}
