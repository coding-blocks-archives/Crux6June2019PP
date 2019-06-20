package L7_June20;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 20-Jun-2019
 *
 */

public class StringDemo {

	public static void main(String[] args) {

		String str = "hello";
		System.out.println(str);

		// length
		System.out.println(str.length());

		// charAt
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(str.length() - 1));

		// substring
		System.out.println(str.substring(0, 3)); // hel
		System.out.println(str.substring(0, 5)); // hello
		// System.out.println(str.substring(4, 2)); // exception
		System.out.println(str.substring(2, 2)); // empty string
		System.out.println(str.substring(1)); // ello

		// concatenate
		String s1 = "hi";
		String s2 = "bye";
		String s3 = s1 + s2;
		System.out.println(s1 + ", " + s2 + ", " + s3);
		String s4 = s1.concat(s2);
		System.out.println(s1 + ", " + s2 + ", " + s4);

		// indexOf
		System.out.println(str.indexOf("eL"));

		// starts with
		System.out.println(str.startsWith("Hel"));
		System.out.println(str.startsWith("hel"));

		// equals and ==
		s1 = "Hello";
		s2 = s1;
		s3 = "Hello";
		s4 = new String("Hello");

		System.out.println((s1 == s2) + ", " + s1.equals(s2));
		System.out.println((s1 == s3) + ", " + s1.equals(s3));
		System.out.println((s1 == s4) + ", " + s1.equals(s4));

		str = str.replace("el", "abc");

		System.out.println(str);
		
		appendString();
	}

	public static void appendString() {

		long start = System.currentTimeMillis();
		int n = 100000;

		String str = "";

		for (int i = 1; i <= n; i++) {
			str += i;
		}

		long end = System.currentTimeMillis();

		System.out.println(end - start);
	}

}
