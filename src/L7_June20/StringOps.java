package L7_June20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jun-2019
 *
 */

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		// String str = scn.next();
		// printChars(str);
		// substrings(str);
		// System.out.println(palindromicSSCount(str));

		String str = "12345";
		int a = Integer.parseInt(str);
		System.out.println(a);

	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
	}

	public static boolean palindrome(String str) {

		int left = 0;
		int right = str.length() - 1;

		while (left < right) {

			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void substrings(String str) {

		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);
				System.out.println(ss);
			}
		}

	}

	public static int palindromicSSCount(String str) {

		int count = 0;

		for (int si = 0; si < str.length(); si++) {
			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);

				if (palindrome(ss))
					count++;
			}
		}

		return count;

	}

}
