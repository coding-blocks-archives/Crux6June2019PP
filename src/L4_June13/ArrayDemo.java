package L4_June13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jun-2019
 *
 */

public class ArrayDemo {

	public static void main(String[] args) {

		int[] arr = null;
		System.out.println(arr);

		arr = new int[5];
		System.out.println(arr);

		// length
		System.out.println(arr.length);

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		// set
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		for (int i = 0; i <= arr.length - 1; i = i + 1) {
			System.out.println(arr[i]);

			// arr[i] = 100;

		}

		// enhanced for loop
		// forward only
		// read only
		for (int val : arr) {

			System.out.println(val);
			val = 100;
			System.out.println(val);
		}

		int i = 0, j = 2;
		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr[i], arr[j]);
		System.out.println(arr[i] + ", " + arr[j]);

		System.out.println(arr[i] + ", " + arr[j]);
		Swap(arr, i, j);
		System.out.println(arr[i] + ", " + arr[j]);

		int[] other = { 100, 200, 300 };
		System.out.println(arr[0] + ", " + other[0]);
		Swap(arr, other);
		System.out.println(arr[0] + ", " + other[0]);

	}

	public static void Swap(int[] one, int[] two) {
		int[] temp = one;
		one = two;
		two = temp;
	}

	public static void Swap(int[] array, int i, int j) {
		System.out.println(array[i] + ", " + array[j]);

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;

		System.out.println(array[i] + ", " + array[j]);
	}

	public static void Swap(int one, int two) {
		int temp = one;
		one = two;
		two = temp;
	}

}
