package L2_June10;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 10-Jun-2019
 *
 */

public class Pattern21 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;

		while (row <= n) {

			// work
			// stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp = csp + 1;
			}

			cst = 1;

			if (row == n) {
				cst = 2;
			}
			
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep
			nst = nst + 1;
			nsp = nsp - 2;
			row = row + 1;
			System.out.println();

		}

	}
}
