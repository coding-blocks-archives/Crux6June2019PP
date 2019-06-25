package Assignments.June25;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class TargetSumPair {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 4, 2, 5 };
		int target = 5;

		Arrays.sort(arr);

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int sum = arr[left] + arr[right];

			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				System.out.println(arr[left] + " and " + arr[right]);
				left++;
				right--;
			}

		}

	}

}
