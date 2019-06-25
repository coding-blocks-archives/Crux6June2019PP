package L7_June20;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 24-Jun-2019
 *
 */

public class StringBuilderDemo {

	public static void main(String[] args) {

		// string to sb
		String s = "hello";
		StringBuilder sb = new StringBuilder(s);

		// length
		System.out.println(sb.length());

		// append
		sb.append("abc");
		System.out.println(sb);
		System.out.println(sb.length());

		// charAt
		System.out.println(sb.charAt(2));

		// insert
		sb.insert(sb.length(), "xyz");
		System.out.println(sb);

		// update
		sb.setCharAt(2, 'q');
		System.out.println(sb);

		// delete
		sb.deleteCharAt(5);
		System.out.println(sb);

		// sb to string
		String str = sb.toString();

		System.out.println(str);

	}

	public static StringBuilder fun() {

		StringBuilder sb = new StringBuilder();

		return sb;
	}

}
