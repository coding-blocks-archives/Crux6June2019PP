package L11_July4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Jul-2019
 *
 */

public class Backtracking {

	static int count = 0;

	public static void main(String[] args) {

		// queenPermutation(new boolean[4], 0, 1, "");
		// queenCombination(new boolean[4], 0, 2, "", 0);
		// coinChangeCombination(new int[] { 2, 3, 5, 6 }, 10, "", 0);

		// queenCombinationBoxRespect(new boolean[4], 0, 0, 4, "");

		// queenCombination2D(new boolean[4][4], 0, 0, 0, 4, "") ;

		int[][] maze = { { 0, 1, 0, 0, }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
	}

	public static void queenPermutation(boolean[] board, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(++count + " " + ans);
			return;
		}

		for (int i = 0; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				queenPermutation(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
				board[i] = false; // no
			}

		}

	}

	public static void queenCombination(boolean[] board, int qpsf, int tq, String ans, int lastBoxUsed) {

		if (qpsf == tq) {
			System.out.println(++count + " " + ans);
			return;
		}

		for (int i = lastBoxUsed + 1; i < board.length; i++) {

			board[i] = true;
			queenCombination(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
			board[i] = false; // no

		}

	}

	public static void coinChangeCombination(int[] denom, int amount, String ans, int lastCoinUsedIdx) {

		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0) {
			return;
		}

		for (int i = lastCoinUsedIdx; i < denom.length; i++) {
			coinChangeCombination(denom, amount - denom[i], ans + denom[i], i);
		}
	}

	public static void queenCombinationBoxRespect(boolean[] board, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board.length) {
			return;
		}

		// place
		board[col] = true;
		queenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col] = false;

		// not place
		queenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);

	}

	public static void queenCombination2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		if (col == board[0].length) {
			row++;
			col = 0;
		}

		if (row == board.length) {
			return;
		}

		// place
		if (isItSafePlaceQueen(board, row, col)) {
			board[row][col] = true;
			queenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		// non place
		queenCombination2D(board, row, col + 1, qpsf, tq, ans);

	}

	public static boolean isItSafePlaceQueen(boolean[][] board, int row, int col) {

		// vertically up
		int r = row - 1;
		int c = col;

		while (r >= 0) {

			if (board[r][c]) {
				return false;
			}

			r--;
		}

		// horizontally left
		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c]) {
				return false;
			}

			c--;
		}

		// diagonally left
		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c--;
		}

		// diagonally right
		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {
			if (board[r][c]) {
				return false;
			}

			r--;
			c++;
		}

		return true;
	}

	public static void blockedMaze(int[][] maze, int row, int col, String ans, boolean[][] visited) {

		if (row == maze.length - 1 && col == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}

		if (row < 0 || row == maze.length || col < 0 || col == maze[0].length || visited[row][col]
				|| maze[row][col] == 1) {
			return;
		}

		visited[row][col] = true;

		// D
		blockedMaze(maze, row + 1, col, ans + "D", visited);
		// T
		blockedMaze(maze, row - 1, col, ans + "T", visited);
		// L
		blockedMaze(maze, row, col - 1, ans + "L", visited);
		// R
		blockedMaze(maze, row, col + 1, ans + "R", visited);

		visited[row][col] = false;

	}

	public static void sudoku(int[][] arr, int row, int col) {

		if (col == arr[0].length) {
			row++;
			col = 0;
		}

		if (row == arr.length) {
			display(arr);
			return;
		}

		if (arr[row][col] != 0) {
			sudoku(arr, row, col + 1);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			arr[row][col] = i;
			sudoku(arr, row, col + 1);
			arr[row][col] = 0;

		}

	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}







