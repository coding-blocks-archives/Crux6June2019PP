package Assignments.June25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class RainWaterTrapping {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

		int[] l = new int[arr.length];
		l[0] = arr[0];

		for (int i = 1; i < arr.length; i++) {
			l[i] = Math.max(l[i - 1], arr[i]);
		}

		int[] r = new int[arr.length];
		r[r.length - 1] = arr[arr.length - 1];

		for (int i = r.length - 2; i >= 0; i--) {
			r[i] = Math.max(r[i + 1], arr[i]);
		}

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {

			ans += Math.min(l[i], r[i]) - arr[i];

		}

		System.out.println(ans);

	}

}
