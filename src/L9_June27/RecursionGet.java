package L9_June27;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 27-Jun-2019
 *
 */

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(getSSAscii("abc").size());
		// System.out.println(getKPC("145"));
		// System.out.println(coinToss(3));
		// System.out.println(permutation("abc"));
		// System.out.println(mazePathDiag(0, 0, 2, 2));

//		System.out.println(boardPath(0, 10));
		
		System.out.println(upperLower("A1z3"));
	}

	public static ArrayList<String> getSS(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
		}

		return mr;

	}

	public static ArrayList<String> getSSAscii(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = getSSAscii(ros);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {
			mr.add(val); // no
			mr.add(ch + val); // yes
			mr.add((int) ch + val); // ascii
		}

		return mr;

	}

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getKPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch); // "abc"

		for (int i = 0; i < code.length(); i++) {

			for (String val : rr) {
				mr.add(code.charAt(i) + val);
			}
		}

		return mr;
	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";

	}

	public static ArrayList<String> coinToss(int n) {

		// base case
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		// smaller problem
		ArrayList<String> rr = coinToss(n - 1);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;

	}

	public static ArrayList<String> permutation(String str) {

		// base case
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		// smaller problem
		ArrayList<String> rr = permutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		// self work
		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {
				String ans = val.substring(0, i) + ch + val.substring(i);
				mr.add(ans);
			}
		}

		return mr;

	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		// +ve base case
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		// -ve base case
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		// if (cc + 1 <= ec) {
		ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec); // H
		for (String val : rrh) {
			mr.add("H" + val);
		}
		// }

		// if (cr + 1 <= er) {
		ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec); // V
		for (String val : rrv) {
			mr.add("V" + val);
		}
		// }

		return mr;
	}

	public static ArrayList<String> mazePathDiag(int cr, int cc, int er, int ec) {

		// +ve base case
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		// -ve base case
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = mazePathDiag(cr, cc + 1, er, ec); // H
		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = mazePathDiag(cr + 1, cc, er, ec); // V
		for (String val : rrv) {
			mr.add("V" + val);
		}

		ArrayList<String> rrd = mazePathDiag(cr + 1, cc + 1, er, ec); // D
		for (String val : rrd) {
			mr.add("D" + val);
		}

		return mr;
	}

	public static ArrayList<String> boardPath(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = boardPath(curr + dice, end);

			for (String val : rr) {
				mr.add(dice + val);
			}
		}

		return mr;
	}

	public static ArrayList<String> upperLower(String str) {

		if (str.length() == 0) {
			ArrayList<String> mr = new ArrayList<>();
			mr.add("");
			return mr;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = upperLower(ros);

		ArrayList<String> mr = new ArrayList<>();

		if (Character.isDigit(ch)) {

			for (String val : rr) {
				mr.add(ch + val);
			}
		} else {
			for (String val : rr) {
				mr.add(Character.toLowerCase(ch) + val);
				mr.add(Character.toUpperCase(ch) + val);
			}
		}

		return mr;
	}

}
