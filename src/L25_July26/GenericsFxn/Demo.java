package L25_July26.GenericsFxn;

import java.util.Comparator;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 26-Jul-2019
 *
 */

public class Demo {

	public static void main(String[] args) {

		Integer[] arr = { 100, 8, 30, 40, 50 };
		bubbleSort(arr);
		
		display(arr);

		String[] sarr = { "hello", "hi", "bye" };
		display(sarr);

		Car[] carr = new Car[5];

		carr[0] = new Car(100, 20, "Black");
		carr[1] = new Car(200, 10, "White");
		carr[2] = new Car(50, 5, "Red");
		carr[3] = new Car(80, 7, "Grey");
		carr[4] = new Car(20, 3, "Brown");

		bubbleSort(carr, new CarSpeedComparator());
		display(carr);

		bubbleSort(carr, new CarPriceComparator());
		display(carr);

		bubbleSort(carr, new CarColorComparator());
		display(carr);

	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int n = arr.length;

		for (int count = 0; count <= n - 2; count++) {

			for (int j = 0; j <= n - count - 2; j++) {

				if (arr[j].compareTo(arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comp) {

		int n = arr.length;

		for (int count = 0; count <= n - 2; count++) {

			for (int j = 0; j <= n - count - 2; j++) {

				if (comp.compare(arr[j], arr[j + 1]) > 0) {

					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}
		System.out.println("-------------");
	}

}








