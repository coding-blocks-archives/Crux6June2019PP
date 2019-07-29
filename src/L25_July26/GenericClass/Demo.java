package L25_July26.GenericClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import L16_July16.InheritanceStory.P;
import L25_July26.GenericsFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class Demo {

	public static void main(String[] args) {

		Pair<Pair<String, Integer>, Pair<Character, Boolean>> p = new Pair<>();

		p.a = new Pair<>();
		p.b = new Pair<>();

		System.out.println(p.a.a);
		System.out.println(p.a.b);
		System.out.println(p.b.a);
		System.out.println(p.b.b);

		// Pair<Integer, String> p = new Pair<>();
		//
		// System.out.println(p.a);
		// System.out.println(p.b);

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		System.out.println(list);

		list.get(0).add(20);
		list.get(0).add(30);
		list.get(1).add(10);

		System.out.println(list);

		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();

		Car[] carr = new Car[5];

		carr[0] = new Car(100, 20, "Black");
		carr[1] = new Car(200, 10, "White");
		carr[2] = new Car(50, 5, "Red");
		carr[3] = new Car(80, 7, "Grey");
		carr[4] = new Car(20, 3, "Brown");

		ll.addLast(carr[0]);
		ll.addLast(carr[1]);
		ll.addLast(carr[2]);
		ll.addLast(carr[3]);
		ll.addFirst(carr[4]);

		ll.display();

	}
}
