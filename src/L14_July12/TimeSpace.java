package L14_July12;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 12-Jul-2019
 *
 */

public class TimeSpace {

	public static void main(String[] args) {

		// System.out.println(polynomial(3, 5));

		// System.out.println(countPalindromicSS("nnitin"));

		// SOE(25);

		System.out.println(Character.toUpperCase('a')); // A

		System.out.println(power(3, 10));

	}

	public static int polynomial(int x, int n) {

		int ans = 0;

		int multiplier = x;

		for (int coeff = n; coeff >= 1; coeff--) {

			ans = ans + coeff * multiplier;
			multiplier = multiplier * x;
		}

		return ans;

	}

	public static int countPalindromicSS(String str) {

		int count = 0;

		// odd length palindromic ss
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even length palindromic ss
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;

	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if (primes[table] == false) {
				continue;
			}

			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}

		for (int i = 0; i < primes.length; i++) {

			if (primes[i])
				System.out.println(i);
		}

	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int sp = power(x, n / 2);
		if (n % 2 == 0) {
			return sp * sp;
		} else {
			return sp * sp * x;
		}

	}
}
