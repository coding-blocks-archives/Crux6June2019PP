package Assignments.June25;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class PairOfRoses {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 2, 5 };
		int target = 5;

		Arrays.sort(arr);

		int fleft = 0;
		int fright = 0;

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int sum = arr[left] + arr[right];

			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {

				fleft = left;
				fright = right;

				left++;
				right--;
			}

		}

		System.out.println("Deepak should buy roses whose prices are " + arr[fleft] + " and " + arr[fright] + ".");

	}

}
