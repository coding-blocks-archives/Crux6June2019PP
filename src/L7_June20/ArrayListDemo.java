package L7_June20;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jun-2019
 *
 */

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);

		// add
		list.add(10);
		System.out.println(list);
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);

		// size
		System.out.println(list.size());

		// get : 0 -> size-1 : constant
		System.out.println(list.get(2));

		// set : 0 -> size-1 : constant
		System.out.println(list.set(0, 100));
		System.out.println(list);

		// add at index : 0 -> size : n
		list.add(0, 50);
		System.out.println(list);

		// remove : 0 -> size-1 : n
		list.remove(1);
		System.out.println(list);

		// loop
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// enhanced for loop
		for (int val : list) {
			System.out.println(val);
		}

	}
}
