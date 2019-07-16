package L15_July15;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class StackClient {

	public static void main(String[] args) throws Exception {

		Stack s = new Stack();

		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		// s.display();
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		s.display();
		s.push(60);
		s.display();
		s.push(80);
		s.push(90);
		// s.push(100);
		// s.push(110);

		System.out.println(s);

	}
}
