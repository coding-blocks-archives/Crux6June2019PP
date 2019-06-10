package L2_June10;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class NumberPattern {

	public static void main(String[] args) {

		int n = 5;
		int nsp = n - 1;
		int nst = 1;

		int val = 1;

		int row = 1;

		while (row <= n) {

			val = row;

			int csp = 1;
			while (csp <= nsp) {
				System.out.print("\t");
				csp = csp + 1;
			}

			int cst = 1;
			while (cst <= nst) {
				System.out.print(val + "\t");

				if (cst <= nst / 2) {
					val = val + 1;
				} else {
					val = val - 1;
				}
				
				cst = cst + 1;
			}

			// prep
			System.out.println();
			row = row + 1;
			nsp = nsp - 1;
			nst = nst + 2;

		}

	}
}
