package L29_July31;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 31-Jul-2019
 *
 */

public class DPDemos {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 10000;
		// System.out.println(fibonacciTD(n, new int[n + 1]));
		// System.out.println(fibonacciBU(n));
		// System.out.println(fibonacciBUSE(n));

		// System.out.println(boardPathTD(0, n, new int[n + 1]));
		// System.out.println(boardPathBU(n));
		// System.out.println(boardPathBUSE(n));

		// System.out.println(mazePathTD(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(mazePathBU(n, n));
		// System.out.println(mazePathBUSE(n, n));

		String s1 = "saturdayjvchjvhdvhjksdhuicvwe";
		String s2 = "sundaybzxjhcgshdgcyu";

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 0; i < strg.length; i++) {
			Arrays.fill(strg[i], -1);
		}

		// System.out.println(LCSTD(s1, s2, strg));
		// System.out.println(LCSBU(s1, s2));

		// System.out.println(EditDistanceTD(s1, s2, strg));
		// System.out.println(EditDistanceBU(s1, s2));

		int[] arr = new int[100];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		int[][] storage = new int[arr.length][arr.length];

		for (int i = 0; i < storage.length; i++) {
			Arrays.fill(storage[i], -1);
		}

		// System.out.println(MCMTD(arr, 0, arr.length - 1, storage));
		// System.out.println(MCMBU(arr));
		//
		// int[] prices = new int[1000];
		// for (int i = 0; i < prices.length; i++) {
		// prices[i] = i + 1;
		// }

		int[] prices = { 2, 3, 5, 1, 4 };

		// System.out.println(WineProblem(prices, 0, prices.length - 1, 1));
		// System.out.println(WineProblemTD(prices, 0, prices.length - 1, new
		// int[prices.length][prices.length]));
		// System.out.println(WineProblemBU(prices));

		String src = "baaababc";
		String pat = "c**************************ba********************************c";

		// System.out.println(WildCardMatching(src, pat));
		// System.out.println(WildCardMatchingTD(src, pat, new int[src.length() +
		// 1][pat.length() + 1]));
		// System.out.println(WildCardMatchingBU(src, pat));

		int[] wt = { 1, 3, 4, 5 };
		int[] p = { 1, 4, 5, 7 };

		int cap = 7;

		// System.out.println(KnapsackTD(wt, p, 0, cap, new int[wt.length][cap + 1]));
		// System.out.println(KnapsackBU(wt, p, cap));

		int[] a = { 40, 60, 20, 30, 45, 12, 26 };

		// System.out.println(MixturesTD(a, 0, a.length - 1, new
		// int[a.length][a.length]));
		// System.out.println(MixturesBU(a));

		int[] price = new int[1000];

		for (int i = 0; i < price.length; i++) {
			price[i] = i + 1;
		}
		// System.out.println(rodCut(price, price.length - 1, new int[price.length]));
		// System.out.println(rodCutBU(price));

		String s = "ababbbabbababadgjhvgsjdhcsdgbcyusdgchjsdgcuywegufwehu";
		// System.out.println(palindromicCuts(s, 0, s.length() - 1, new
		// int[s.length()][s.length()]));
		// System.out.println(palindromicCutsBU(s));

		for (int i = 0; i <= 10; i++)
			System.out.println(i + " : " + noOfBSTS(i));

		long end = System.currentTimeMillis();

		System.out.println(end - start);

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1)
			return n;

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static int fibonacciTD(int n, int[] strg) {

		if (n == 0 || n == 1)
			return n;

		if (strg[n] != 0) { // re-use
			return strg[n];
		}

		int fnm1 = fibonacciTD(n - 1, strg);
		int fnm2 = fibonacciTD(n - 2, strg);

		int fn = fnm1 + fnm2;

		strg[n] = fn; // store

		return fn;

	}

	// T : O(n) , S : O(n)
	public static int fibonacciBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];

	}

	// T : O(n) , S : O(1)
	public static int fibonacciBUSE(int n) {

		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;

		for (int slide = 1; slide <= n - 1; slide++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}

		return strg[1];

	}

	public static int boardPathTD(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int c = 0;
		for (int dice = 1; dice <= 6; dice++) {
			c += boardPathTD(curr + dice, end, strg);
		}

		strg[curr] = c;
		return c;
	}

	public static int boardPathBU(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int boardPathBUSE(int n) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= n; slide++) {

			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}

		return strg[0];

	}

	// T : O(n^2) S : O(n^2)
	public static int mazePathTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathTD(cr, cc + 1, er, ec, strg);
		int cv = mazePathTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;
		return ch + cv;

	}

	// T : O(n^2) S : O(n^2)
	public static int mazePathBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {

				if (r == er && c == ec) {
					strg[er][ec] = 1;
					continue;
				}

				strg[r][c] = strg[r + 1][c] + strg[r][c + 1];
			}
		}

		return strg[0][0];

	}

	public static int mazePathBUSE(int er, int ec) {

		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int slide = er - 1; slide >= 0; slide--) {

			for (int c = ec - 1; c >= 0; c--) {
				strg[c] = strg[c] + strg[c + 1];
			}
		}

		return strg[0];

	}

	// T : O(2^(m+n)) S : Rec extra space
	public static int LCS(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int o1 = LCS(s1, ros2);
			int o2 = LCS(ros1, s2);

			ans = Math.max(o1, o2);

		}

		return ans;

	}

	// T : O(m*n) S : Rec extra space + 2D Array
	public static int LCSTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = LCSTD(ros1, ros2, strg) + 1;
		} else {
			int o1 = LCSTD(s1, ros2, strg);
			int o2 = LCSTD(ros1, s2, strg);

			ans = Math.max(o1, o2);

		}

		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	// T : O(m*n) S : O(m*n)
	public static int LCSBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length() - 1; row >= 0; row--) {

			for (int col = s2.length() - 1; col >= 0; col--) {

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1] + 1;
				} else {

					int o1 = strg[row][col + 1];
					int o2 = strg[row + 1][col];

					strg[row][col] = Math.max(o1, o2);
				}

			}
		}

		return strg[0][0];

	}

	// T : O(3^(m+n)) S : Rec extra space
	public static int EditDistance(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int i = EditDistance(ros1, s2);
			int d = EditDistance(s1, ros2);
			int r = EditDistance(ros1, ros2);

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		return ans;

	}

	// T : O(n*m) S : Rec Extra Space O(n*m)
	public static int EditDistanceTD(String s1, String s2, int[][] strg) {

		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}

		if (strg[s1.length()][s2.length()] != -1) {
			return strg[s1.length()][s2.length()];
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = EditDistanceTD(ros1, ros2, strg);
		} else {
			int i = EditDistanceTD(ros1, s2, strg);
			int d = EditDistanceTD(s1, ros2, strg);
			int r = EditDistanceTD(ros1, ros2, strg);

			ans = Math.min(i, Math.min(d, r)) + 1;
		}

		strg[s1.length()][s2.length()] = ans;

		return ans;

	}

	// T : O(n*m) S : O(n*m)
	public static int EditDistanceBU(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {

			for (int col = s2.length(); col >= 0; col--) {

				if (row == s1.length()) {
					strg[row][col] = s2.length() - col;
					continue;
				}

				if (col == s2.length()) {
					strg[row][col] = s1.length() - row;
					continue;
				}

				if (s1.charAt(row) == s2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {

					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];

					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;

				}

			}

		}

		return strg[0][0];

	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != -1) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = MCMTD(arr, si, k, strg);
			int sp = MCMTD(arr, k, ei, strg);

			int sw = arr[si] * arr[k] * arr[ei];

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		strg[si][ei] = min;

		return min;

	}

	public static int MCMBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 2; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				// copy
				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k][ei];

					int sw = arr[si] * arr[k] * arr[ei];

					int total = fp + sp + sw;

					if (total < min) {
						min = total;
					}

				}

				strg[si][ei] = min;
				//

			}

		}

		return strg[0][n - 1];

	}

	// T : O(2^n) S : Rec extra space
	public static int WineProblem(int[] arr, int si, int ei, int yr) {

		if (si == ei) {
			return arr[si] * yr;
		}

		int start = WineProblem(arr, si + 1, ei, yr + 1) + arr[si] * yr;
		int end = WineProblem(arr, si, ei - 1, yr + 1) + arr[ei] * yr;

		int ans = Math.max(start, end);

		return ans;
	}

	// T : O(n*n) // S : Rec extra space + Array
	public static int WineProblemTD(int[] arr, int si, int ei, int[][] strg) {

		int yr = arr.length - ei + si;

		if (si == ei) {
			return arr[si] * yr;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int start = WineProblemTD(arr, si + 1, ei, strg) + arr[si] * yr;
		int end = WineProblemTD(arr, si, ei - 1, strg) + arr[ei] * yr;

		int ans = Math.max(start, end);

		strg[si][ei] = ans;

		return ans;
	}

	public static int WineProblemBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				int yr = arr.length - ei + si;

				if (si == ei) {
					strg[si][ei] = arr[si] * yr;
					continue;
				}

				// copy
				int start = strg[si + 1][ei] + arr[si] * yr;
				int end = strg[si][ei - 1] + arr[ei] * yr;

				int ans = Math.max(start, end);

				strg[si][ei] = ans;
				//

			}

		}

		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[i].length; j++) {
				System.out.print(strg[i][j] + "\t");
			}
			System.out.println();
		}

		return strg[0][n - 1];

	}

	public static boolean WildCardMatching(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean res;
		if (chs == chp || chp == '?') {
			res = WildCardMatching(ros, rop);
		} else if (chp == '*') {

			boolean blank = WildCardMatching(src, rop);
			boolean multiple = WildCardMatching(ros, pat);

			res = blank || multiple;

		} else {
			res = false;
		}

		return res;
	}

	public static boolean WildCardMatchingTD(String src, String pat, int[][] strg) {

		if (src.length() == 0 && pat.length() == 0) {
			return true;
		}

		if (src.length() != 0 && pat.length() == 0) {
			return false;
		}

		if (src.length() == 0 && pat.length() != 0) {

			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		if (strg[src.length()][pat.length()] != 0) {
			return (strg[src.length()][pat.length()] == 2) ? true : false;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean res;
		if (chs == chp || chp == '?') {
			res = WildCardMatchingTD(ros, rop, strg);
		} else if (chp == '*') {

			boolean blank = WildCardMatchingTD(src, rop, strg);
			boolean multiple = WildCardMatchingTD(ros, pat, strg);

			res = blank || multiple;

		} else {
			res = false;
		}

		strg[src.length()][pat.length()] = (res ? 2 : 1);

		return res;
	}

	public static boolean WildCardMatchingBU(String src, String pat) {

		boolean[][] strg = new boolean[src.length() + 1][pat.length() + 1];

		strg[src.length()][pat.length()] = true;

		for (int row = src.length(); row >= 0; row--) {

			for (int col = pat.length() - 1; col >= 0; col--) {

				// last row
				if (row == src.length()) {

					if (pat.charAt(col) == '*') {
						strg[row][col] = strg[row][col + 1];
					} else {
						strg[row][col] = false;
					}

					continue;
				}

				// copy
				char chs = src.charAt(row);
				char chp = pat.charAt(col);

				boolean res;
				if (chs == chp || chp == '?') {
					res = strg[row + 1][col + 1];
				} else if (chp == '*') {

					boolean blank = strg[row][col + 1];
					boolean multiple = strg[row + 1][col];

					res = blank || multiple;

				} else {
					res = false;
				}

				strg[row][col] = res;

			}

		}

		return strg[0][0];

	}

	public static int KnapsackTD(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == wt.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int exclude = KnapsackTD(wt, price, vidx + 1, cap, strg);

		int include = 0;
		if (cap >= wt[vidx])
			include = KnapsackTD(wt, price, vidx + 1, cap - wt[vidx], strg) + price[vidx];

		int ans = Math.max(exclude, include);

		strg[vidx][cap] = ans;

		return ans;
	}

	public static int KnapsackBU(int[] wt, int[] price, int cap) {

		int[][] strg = new int[wt.length + 1][cap + 1];

		for (int row = strg.length - 2; row >= 0; row--) {

			for (int col = 1; col < strg[0].length; col++) {

				// bottom cell
				int exclude = strg[row + 1][col];

				int include = 0;
				if (col >= wt[row])
					include = strg[row + 1][col - wt[row]] + price[row];

				int ans = Math.max(exclude, include);

				strg[row][col] = ans;

			}

		}

		return strg[0][cap];

	}

	public static int MixturesTD(int[] arr, int si, int ei, int[][] strg) {

		if (si == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = MixturesTD(arr, si, k, strg);
			int sp = MixturesTD(arr, k + 1, ei, strg);

			int sw = color(arr, si, k) * color(arr, k + 1, ei);

			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}
		}

		strg[si][ei] = min;

		return min;

	}

	public static int color(int[] arr, int si, int ei) {

		int sum = 0;
		for (int i = si; i <= ei; i++) {
			sum += arr[i];
		}

		return sum % 100;
	}

	public static int MixturesBU(int[] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int slide = 1; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// copy
				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k + 1][ei];

					int sw = color(arr, si, k) * color(arr, k + 1, ei);

					int total = fp + sp + sw;

					if (total < min) {
						min = total;
					}
				}

				strg[si][ei] = min;

			}

		}

		return strg[0][n - 1];

	}

	public static int rodCut(int[] arr, int len, int[] strg) {

		if (strg[len] != 0) {
			return strg[len];
		}

		int max = arr[len];

		int left = 1;
		int right = len - 1;

		while (left <= right) {

			int fp = rodCut(arr, left, strg);
			int sp = rodCut(arr, right, strg);

			int total = fp + sp;

			if (total > max) {
				max = total;
			}

			left++;
			right--;

		}

		strg[len] = max;

		return max;

	}

	public static int rodCutBU(int[] arr) {

		int[] strg = new int[arr.length];

		for (int len = 1; len < strg.length; len++) {

			int max = arr[len];

			int left = 1;
			int right = len - 1;

			while (left <= right) {

				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max) {
					max = total;
				}

				left++;
				right--;

			}

			strg[len] = max;

		}

		return strg[strg.length - 1];

	}

	public static int palindromicCuts(String str, int si, int ei, int[][] strg) {

		if (isPalindrome(str, si, ei)) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si; k <= ei - 1; k++) {

			int fp = palindromicCuts(str, si, k, strg);
			int sp = palindromicCuts(str, k + 1, ei, strg);

			int total = fp + sp + 1;

			if (total < min) {
				min = total;
			}
		}

		strg[si][ei] = min;

		return min;
	}

	public static boolean isPalindrome(String str, int si, int ei) {

		int i = si;
		int j = ei;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;

	}

	public static int palindromicCutsBU(String str) {

		int n = str.length();
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				// base case
				if (isPalindrome(str, si, ei)) {
					strg[si][ei] = 0;
					continue;
				}

				// copy
				int min = Integer.MAX_VALUE;

				for (int k = si; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k + 1][ei];

					int total = fp + sp + 1;

					if (total < min) {
						min = total;
					}
				}

				strg[si][ei] = min;
				//
			}
		}

		return strg[0][n - 1];
	}

	public static int noOfBSTS(int n) {

		if (n <= 1) {
			return 1;
		}

		int sum = 0;

		for (int i = 1; i <= n; i++) {

			int left = noOfBSTS(i - 1);
			int right = noOfBSTS(n - i);

			int total = left * right;

			sum += total;
		}

		return sum;
	}
}
