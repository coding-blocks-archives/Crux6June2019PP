package L4_June13;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 13-Jun-2019
 *
 */

public class FunctionDemo {

	static int val = 100;

	public static void main(String[] args) {

		System.out.println("hello");

		// fxn call
		// addition();

		// subtraction();

		int n1 = 5;
		int n2 = 10;
		// additionParams(n1, n2);

		int sum = additionReturn(10, 5);
		System.out.println(sum);

		System.out.println(val); // 100 : global
		int val = 10;
		System.out.println(val); // 10 : local
		System.out.println(FunctionDemo.val); // 100 : global

		globalDemo(20);
		System.out.println(val);
		System.out.println(FunctionDemo.val);

		System.out.println("bye");
		// Part-5 : Pass by value

		System.out.println("----------- Part-5 -----------");
		int one = 10, two = 20;
		System.out.println(one + ", " + two);
		Swap(one, two);
		System.out.println(one + ", " + two);

		System.out.println("bye");

	}

	public static void Swap(int one, int two) {
		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static void globalDemo(int a) {

		val = 200;
		int sum = a + val;
		System.out.println(sum);
	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public static void additionParams(int a, int b) {

		int sum = a + b;

		System.out.println(sum);

		// return;
	}

	// fxn definition
	public static void addition() {

		int a = 2;
		int b = 3;

		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 20;
		int b = 3;

		int sub = a - b;

		System.out.println(sub);
	}

}
