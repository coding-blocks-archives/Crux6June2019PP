package L11_July4;

import java.util.Scanner;

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

		// int[][] maze = { { 0, 1, 0, 0, }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1,
		// 0 } };
		// blockedMaze(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);

		// Scanner scn = new Scanner(System.in);
		//
		// int[][] arr = new int[9][9];
		//
		// for (int i = 0; i < arr.length; i++) {
		// for (int j = 0; j < arr[0].length; j++) {
		// arr[i][j] = scn.nextInt();
		// }
		//
		// }
		//
		// sudoku(arr, 0, 0);

		char[][] arr = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'F', 'E' } };
		
		boolean ans = false ;
		String word ="SEE"  ;
		
		for(int i=0 ; i < arr.length ; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] == word.charAt(0)) {
					ans = ans || wordSearch(arr, i, j, word, 0, new boolean[arr.length][arr[0].length]) ;
				}
			}
		}
		
		System.out.println(ans);

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

			if (isItSafe(arr, row, col, i)) {

				arr[row][col] = i;
				sudoku(arr, row, col + 1);
				arr[row][col] = 0;
			}

		}

	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");

				if (j == 2 || j == 5) {
					System.out.print("     ");
				}
			}
			System.out.println();

			if (i == 2 || i == 5) {
				System.out.println();

			}
		}

		System.out.println("-----------------------------");
	}

	public static boolean isItSafe(int[][] arr, int row, int col, int val) {

		return isItSafeRow(arr, row, val) && isItSafeCol(arr, col, val) && isItSafeCell(arr, row, col, val);
	}

	public static boolean isItSafeRow(int[][] arr, int row, int val) {

		for (int col = 0; col < arr[0].length; col++) {

			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;

	}

	public static boolean isItSafeCol(int[][] arr, int col, int val) {

		for (int row = 0; row < arr.length; row++) {

			if (arr[row][col] == val) {
				return false;
			}
		}

		return true;

	}

	public static boolean isItSafeCell(int[][] arr, int row, int col, int val) {

		int sr = row - row % 3;
		int sc = col - col % 3;

		for (int r = sr; r < sr + 3; r++) {

			for (int c = sc; c < sc + 3; c++) {
				if (arr[r][c] == val) {
					return false;
				}
			}
		}

		return true;

	}

	public static boolean wordSearch(char[][] arr, int row, int col, String word, int idx, boolean[][] visited) {

		if (idx == word.length()) {
			return true;
		}

		if (row < 0 || row == arr.length || col < 0 || col == arr[0].length || visited[row][col]) {
			return false;
		}

		if (arr[row][col] != word.charAt(idx)) {
			return false;
		}

		visited[row][col] = true;

		// T
		boolean t = wordSearch(arr, row - 1, col, word, idx + 1, visited);
		// L
		boolean l = wordSearch(arr, row, col - 1, word, idx + 1, visited);
		// R
		boolean r = wordSearch(arr, row, col + 1, word, idx + 1, visited);
		// B
		boolean b = wordSearch(arr, row + 1, col, word, idx + 1, visited);

		visited[row][col] = false;

		return t || l || r || b;

	}

}













