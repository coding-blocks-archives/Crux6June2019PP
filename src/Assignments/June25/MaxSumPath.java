package Assignments.June25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class MaxSumPath {

	public static void main(String[] args) {

		int[] one = { 2, 3, 7, 10, 12, 15, 30, 34 };
		int[] two = { 1, 5, 7, 8, 10, 15, 16, 19 };

		int sum1 = 0;
		int sum2 = 0;

		int finalAns = 0;

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				sum1 += one[i];
				i++;
			} else if (one[i] > two[j]) {
				sum2 += two[j];
				j++;
			} else {

				finalAns += Math.max(sum1, sum2) + one[i];

				i++;
				j++;

				sum1 = 0;
				sum2 = 0;

			}

		}

		if (i == one.length) {
			while (j < two.length) {
				sum2 += two[j];
				j++;
			}
		}

		if (j == two.length) {
			while (i < one.length) {
				sum1 += one[i];
				i++;
			}
		}

		finalAns += Math.max(sum1, sum2);

		System.out.println(finalAns);

	}
}
