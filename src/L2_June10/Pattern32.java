package L2_June10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class Pattern32 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;
		int row = 1;

		int val = 1;

		while (row <= 2 * n - 1) {

			int cst = 1;
			while (cst <= nst) {

				if (cst % 2 == 0)
					System.out.print("*");
				else
					System.out.print(val);

				cst = cst + 1;
			}

			// prep
			if (row <= n - 1) {
				val = val + 1;
				nst = nst + 2;
			} else {
				val = val - 1;
				nst = nst - 2;
			}

			System.out.println();
			row = row + 1;

		}

	}
}
