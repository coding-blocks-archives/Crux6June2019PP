package L6_June18;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 18-Jun-2019
 *
 */

public class Array2DDemo {

	public static void main(String[] args) {

		int[][] arr = new int[3][5];
		System.out.println(arr);

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);

		System.out.println(arr[1][3]);

		// rows
		System.out.println(arr.length);

		// cols
		System.out.println(arr[0].length);

	}
}
