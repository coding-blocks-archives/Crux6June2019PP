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

		queenPermutation(new boolean[4], 0, 1, "");
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

}
