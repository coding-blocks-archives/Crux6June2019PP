package L4_June13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jun-2019
 *
 */

public class FunctionOps {

	public static void main(String[] args) {

		// printAllPrimes(10, 100);
		printAllArmstrong(10, 1000);
	}

	public static void printAllPrimes(int lo, int hi) {

		int n = lo;

		while (n <= hi) {

			boolean res = isPrime(n);
			if (res)
				System.out.println(n);

			n = n + 1;
		}

	}

	public static boolean isPrime(int n) {

		int div = 2;

		while (div < n) {

			if (n % div == 0) {
				return false;
			}

			div = div + 1;
		}

		return true;
	}

	public static void printAllArmstrong(int lo, int hi) {

		int n = lo;
		while (n <= hi) {

			boolean res = isArmstrong(n);
			if (res)
				System.out.println(n);

			n = n + 1;
		}
	}

	public static boolean isArmstrong(int n) {

		int nod = numberOfDigits(n);
		int ans = 0;

		int temp = n ;
		
		while (n != 0) {

			int rem = n % 10;
			ans = ans + (int) Math.pow(rem, nod);
			n = n / 10;
		}

		if (ans == temp)
			return true;
		else
			return false;
	}

	public static int numberOfDigits(int n) {

		int count = 0;

		while (n != 0) {
			n = n / 10;
			count = count + 1;
		}

		return count;

	}

}
