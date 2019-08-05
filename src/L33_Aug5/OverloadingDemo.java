package L33_Aug5;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 05-Aug-2019
 *
 */

public class OverloadingDemo {

	public static void main(String[] args) {

		System.out.println(add(2, 3));
		add(7, 8);
		System.out.println(add(3, 4, 5));
		System.out.println(add(3.5, 4.9));
		System.out.println(add(2, 3, 4, 5));

	}

	public static int add(int a, int b) {
		System.out.println("in two params");
		return a + b;
	}

	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	public static int add(double a, double b) {
		return (int) (a + b);
	}

	// only one variable args is allowed
	// variable args should be at the end of list
	public static int add(int a, int b, int... args) {

		int sum = 0;
		for (int val : args) {
			sum += val;
		}

		return sum;
	}
}
