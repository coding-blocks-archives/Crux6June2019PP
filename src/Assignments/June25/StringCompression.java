package Assignments.June25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class StringCompression {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.next();

		String ans = "";
		int count = 1;

		for (int i = 0; i < str.length() - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1)) {
				count++;

			} else {

				ans += str.charAt(i);
				if (count > 1)
					ans += count;

				count = 1;

			}

		}

		ans += str.charAt(str.length()-1);
		if (count > 1)
			ans += count;

		System.out.println(ans);
	}
}
