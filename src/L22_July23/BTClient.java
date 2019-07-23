package L22_July23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2019
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(500));
		System.out.println(bt.ht());

	}
}
