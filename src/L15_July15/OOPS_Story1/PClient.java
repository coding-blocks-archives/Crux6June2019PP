package L15_July15.OOPS_Story1;

import java.util.ArrayList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class PClient {

	public static void main(String[] args) {

		System.out.println("hii");

		Person p = new Person();

		try {
			System.out.println("hi try");
			p.fun(10);
			System.out.println("bye try");
		} catch (Exception e) {
			System.out.println("in e");
		} finally {
			System.out.println("in finally");
		}

		System.out.println(p.getAge());

		System.out.println(p);

		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list);

	}
}
