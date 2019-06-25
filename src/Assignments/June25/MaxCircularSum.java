package Assignments.June25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class MaxCircularSum {

	public static void main(String[] args) {

		int[] arr = { 8, -8, 9, -9, 10, -11, 12 };

		int finalSum = 0;

		for (int si = 0; si < arr.length; si++) {

			int sum = 0;

			for (int ei = 0; ei < arr.length; ei++) {

				int k = (si + ei) % arr.length;
				sum += arr[k];
				
				if (sum > finalSum) {
					finalSum = sum;
				}

			}

		}

		System.out.println(finalSum);

	}
}
