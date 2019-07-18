package L17_July17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();

		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.display();
		list.addLast(50);
		list.addLast(60);
		list.display();
		// System.out.println(list.removeFirst());
		// list.display();
		//
		// System.out.println(list.removeLast());
		// list.display();
		//
		// System.out.println(list.removeAt(1));
		// list.display();

		list.RDR();
		list.display();

	}
}
