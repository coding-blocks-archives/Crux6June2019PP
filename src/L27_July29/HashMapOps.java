package L27_July29;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 29-Jul-2019
 *
 */

public class HashMapOps {

	public static void main(String[] args) {

		System.out.println(maxFreqChar("aaabbbbaaaaa"));

		int[] one = { 10, 20, 10, 10, 30, 30 };
		int[] two = { 30, 60, 30, 30, 10 };

		System.out.println(intersection(one, two));

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		longestConsecutiveSeq(arr);
	}

	public static char maxFreqChar(String str) {

		int maxFreq = 0;
		char maxFreqChar = ' ';

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (map.containsKey(ch)) {
				int of = map.get(ch);
				map.put(ch, of + 1);
			} else {
				map.put(ch, 1);
			}

			if (map.get(ch) > maxFreq) {
				maxFreq = map.get(ch);
				maxFreqChar = ch;
			}
		}

		return maxFreqChar;

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i < one.length; i++) {
			int val = one[i];

			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
		}

		for (int j = 0; j < two.length; j++) {

			if (map.containsKey(two[j])) {

				ans.add(two[j]);
				map.put(two[j], map.get(two[j]) - 1);

				if (map.get(two[j]) == 0) {
					map.remove(two[j]);
				}

			}
		}

		return ans;

	}

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int max = 0;
		int start = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > max) {
					max = count;
					start = key;
				}

			}

		}

		for (int i = 0; i < max; i++) {
			System.out.println(start + i);
		}

	}

}
