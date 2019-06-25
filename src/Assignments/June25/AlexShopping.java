package Assignments.June25;

import java.util.Scanner;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jun-2019
 *
 */

public class AlexShopping {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int queries = scn.nextInt();

		for (int q = 1; q <= queries; q++) {

			int price = scn.nextInt();
			int items = scn.nextInt();

			int count = 0;

			for (int i = 0; i < arr.length; i++) {

				if (price % arr[i] == 0) {
					count++;
				}
			}

			if (count >= items) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

	}
}
