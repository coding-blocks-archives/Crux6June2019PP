package L8_June24;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jun-2019
 *
 */

public class Recursion {

	public static void main(String[] args) {

		// PDI(3);
		// System.out.println(factorial(4));
		// System.out.println(power(2, 10));

		// System.out.println(fibonacci(10));

		int[] arr = { 10, 20, 30, 40, 50, 30, 30 };
		// displayReverse(arr, 0);
		// System.out.println(max(arr, 0));
		// System.out.println(findFirstIndex(arr, 0, 30));
		// System.out.println(findLastIndex(arr, 0, 30));

		int[] ans = findAllIndex(arr, 0, 30, 0);
		for (int val : ans) {
			System.out.println(val);
		}

	}

	public static void PD(int n) {

		if (n == 0)
			return;

		System.out.println(n);
		PD(n - 1);

	}

	public static void PI(int n) {

		// base case
		if (n == 0)
			return;

		// smaller problem
		PI(n - 1);

		// self work
		System.out.println(n);

	}

	public static void PDI(int n) {

		if (n == 0)
			return;

		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static int factorial(int n) {

		// base case
		if (n == 1)
			return 1;

		// smaller problem
		int fnm1 = factorial(n - 1);

		// self work
		int fn = fnm1 * n;

		return fn;

	}

	public static int power(int x, int n) {

		if (n == 0)
			return 1;

		int pnm1 = power(x, n - 1);
		int pn = pnm1 * x;

		return pn;

	}

	public static int fibonacci(int n) {

		if (n == 0 || n == 1)
			return n;

		int fnm1 = fibonacci(n - 1);
		int fnm2 = fibonacci(n - 2);

		int fn = fnm1 + fnm2;

		return fn;

	}

	public static void display(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		display(arr, vidx + 1);

	}

	public static void displayReverse(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		displayReverse(arr, vidx + 1);
		System.out.println(arr[vidx]);

	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int rr = max(arr, vidx + 1);

		if (arr[vidx] > rr) {
			return arr[vidx];
		} else {
			return rr;
		}
	}

	public static int findFirstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		return findFirstIndex(arr, vidx + 1, item);

	}

	public static int findLastIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length) {
			return -1;
		}

		int rr = findLastIndex(arr, vidx + 1, item);

		if (arr[vidx] == item && rr == -1) {
			return vidx;
		}

		return rr;

	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] rr = new int[count];
			return rr;
		}

		int[] rr;

		if (arr[vidx] == item) {
			rr = findAllIndex(arr, vidx + 1, item, count + 1);
			rr[count] = vidx;
		} else {
			rr = findAllIndex(arr, vidx + 1, item, count);
		}

		return rr;

	}

}
