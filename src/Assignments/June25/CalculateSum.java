package Assignments.June25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class CalculateSum {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		int q = scn.nextInt();

		for (int ops = 1; ops <= q; ops++) {

			int x = scn.nextInt();

			int[] na = new int[arr.length];

			for (int i = 0; i < na.length; i++) {

				int idx = i - x;

				if (idx < 0)
					idx += arr.length;

				na[i] = arr[i] + arr[idx];
			}

			arr = na;

		}

		int sum = 0;
		for (int val : arr) {
			sum += val % 1000000007;
		}

		System.out.println(sum);
	}

}
