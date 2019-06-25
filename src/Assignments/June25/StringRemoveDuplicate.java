package Assignments.June25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class StringRemoveDuplicate {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.next();

		String ans = "";

		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1)) {

			} else {
				ans += str.charAt(i);
			}

		}

		ans += str.charAt(str.length() - 1);

		System.out.println(ans);
	}
}
