package Assignments.June25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class ToggleCase {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		String str = scn.next();
		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 'A' && ch <= 'Z') {
				ans += Character.toLowerCase(ch);
			} else if (ch >= 'a' && ch <= 'z') {
				ans += Character.toUpperCase(ch);
			}

		}

		System.out.println(ans);

	}
}
