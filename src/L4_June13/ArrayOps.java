package L4_June13;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jun-2019
 *
 */

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] arr = takeInput();
		// int[] arr = { 90, 80, 70, 60, 50 };
		// display(arr);
		// System.out.println(linearSearch(arr, 30));
		// System.out.println(binarySearch(arr, 30));

		// rotate(arr, -23);
		// display(arr);
		// subarrays(arr);

		// subsets(arr);
		// bubbleSort(arr);
		// selectionSort(arr);
		// insertionSort(arr);
		// display(arr);

		int[] arr = new int[100000];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr.length - i;

		}

		long start = System.currentTimeMillis();
		// bubbleSort(arr);
		insertionSort(arr);
		long end = System.currentTimeMillis();

		System.out.println(end - start);

	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();

	}

	public static int max(int[] arr) {

		int m = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > m) {
				m = arr[i];
			}
		}

		return m;

	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i <= arr.length - 1; i++) {

			if (arr[i] == item) {
				return i;
			}
		}

		return -1; // element is not present

	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) {
				lo = mid + 1;
			} else if (item < arr[mid]) {
				hi = mid - 1;
			} else {
				return mid;
			}

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int left = 0;
		int right = arr.length - 1;

		while (left < right) {

			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;

			left++;
			right--;

		}
	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		if (rot < 0) {
			rot = rot + arr.length;
		}

		for (int r = 1; r <= rot; r++) {

			int temp = arr[arr.length - 1];

			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}

			arr[0] = temp;

		}

	}

	public static int[] inverse(int[] arr) {

		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}

		return inv;
	}

	public static void subarrays(int[] arr) {

		for (int si = 0; si <= arr.length - 1; si++) {

			for (int ei = si; ei <= arr.length - 1; ei++) {

				for (int k = si; k <= ei; k++) {
					System.out.print(arr[k] + " ");
				}

				System.out.println();

			}
		}
	}

	public static void subsets(int[] arr) {

		int limit = (int) Math.pow(2, arr.length);

		for (int n = 0; n <= limit - 1; n++) {

			int temp = n;

			for (int i = 0; i < arr.length; i++) {
				int rem = temp % 2;

				if (rem == 1) {
					System.out.print(arr[i] + " ");
				}

				temp = temp / 2;

			}

			System.out.println();

		}

	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		boolean flag = true;

		for (int count = 0; count <= n - 2; count++) {

			for (int j = 0; j <= n - count - 2; j++) {

				if (arr[j] > arr[j + 1]) {

					flag = false;

					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			if (flag)
				break;

		}

	}

	public static void selectionSort(int[] arr) {

		int n = arr.length;

		for (int count = 0; count <= n - 2; count++) {

			int min = count;
			for (int j = count + 1; j <= n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}
			}

			// swap
			int temp = arr[min];
			arr[min] = arr[count];
			arr[count] = temp;

		}

	}

	public static void insertionSort(int[] arr) {

		int n = arr.length;

		for (int count = 1; count <= n - 1; count++) {

			int temp = arr[count];

			int j = count - 1;

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = temp;

		}

	}

}
