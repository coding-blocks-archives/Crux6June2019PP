import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 06-Jun-2019
 *
 */

public class GCD {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		int start;

		if (n1 > n2) {
			start = n2;
		} else {
			start = n1;
		}

		int div = start;

		while (div >= 1) {

			if (n1 % div == 0 && n2 % div == 0) {
				break ;
			}

			div = div - 1;
		}
		
		System.out.println(div);

	}
}









