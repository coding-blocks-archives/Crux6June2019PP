package L10_July1;

import L9_June27.RecursionGet;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 01-Jul-2019
 *
 */

public class RecursionPrint {

	public static void main(String[] args) {

		// printSS("abc", "");
		// printKPC("145", "");
		// permutation2("abc", "");
		 validParenthesis(10, "", 0, 0);
		// permutation("abac", "");
		// permutationNoDuplicates("abac", "");

		// System.out.println(boardPath(0, 10, ""));
		// System.out.println(mazePath(0, 0, 2, 2, ""));

		// lexicoCounting(0, 1000);
		// palindromePartition("abbcbc", "");
//
//		upperLower("A1bC", "");
	}

	public static void printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSS(roq, ans); // no
		printSS(roq, ans + ch); // yes

	}

	public static void printKPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = RecursionGet.getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			printKPC(roq, ans + code.charAt(i));
		}
	}

	public static void permutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			permutation(roq, ans + ch);

		}

	}

	public static void permutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		for (int i = 0; i <= ans.length(); i++) {
			permutation2(roq, ans.substring(0, i) + ch + ans.substring(i));
		}

	}

	static int c = 1 ;
	
	public static void validParenthesis(int n, String ans, int open, int close) {

		if (open == n && close == n) {
			System.out.println(c++ + " "  +ans);
			return;
		}

		if (open > n || close > n || close > open) {
			return;
		}

		validParenthesis(n, ans + "(", open + 1, close);
		validParenthesis(n, ans + ")", open, close + 1);

	}

	public static void permutationNoDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			int flag = 0;
			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag++;
				}
			}

			if (flag == 0)
				permutationNoDuplicates(roq, ans + ch);

		}

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPath(curr + dice, end, ans + dice);
		}

		return c;
	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int ch = mazePath(cr, cc + 1, er, ec, ans + "H");
		int cv = mazePath(cr + 1, cc, er, ec, ans + "V");

		return ch + cv;

	}

	public static void lexicoCounting(int curr, int end) {

		if (curr > end) {
			return;
		}

		System.out.println(curr);

		int i = 0;

		if (curr == 0)
			i = 1;

		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, end);
		}

	}

	public static boolean isPalindrome(String str) {

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

	public static void palindromePartition(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String roq = ques.substring(i);
			String part = ques.substring(0, i);

			if (isPalindrome(part)) {
				palindromePartition(roq, ans + part + " ");
			}

		}

	}

	public static void upperLower(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (Character.isDigit(ch)) {
			upperLower(roq, ans + ch);
		} else {

			upperLower(roq, ans + Character.toLowerCase(ch));
			upperLower(roq, ans + Character.toUpperCase(ch));

		}

	}

}
