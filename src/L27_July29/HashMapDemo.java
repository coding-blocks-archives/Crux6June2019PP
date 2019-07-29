package L27_July29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put : O(1)
		map.put("India", 10);
		map.put("England", 20);
		map.put("SL", 30);

		System.out.println(map);

		map.put("SL", 40);

		System.out.println(map);

		// get : O(1)
		System.out.println(map.get("SL"));
		System.out.println(map.get("Aus"));

		// contains key : O(1)
		System.out.println(map.containsKey("SL"));
		System.out.println(map.containsKey("Aus"));

		// remove : O(1)
		// System.out.println(map.remove("SL")); //
		System.out.println(map.remove("Aus")); // null

		// keyset
		// way 1
		Set<String> keys = map.keySet();

		System.out.println(keys);

		for (String val : keys) {
			System.out.println(val + " -> " + map.get(val));
		}

		// way 2
		for (String val : map.keySet()) {
			System.out.println(val + " -> " + map.get(val));
		}

		// way 3
		ArrayList<String> list = new ArrayList<>(map.keySet());

		for (String val : list) {
			System.out.println(val);
		}

	}
}
