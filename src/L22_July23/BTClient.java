package L22_July23;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 23-Jul-2019
 *
 */

public class BTClient {

	// 10 true 20 true 40 false false true 50 false false true 30 false true 60
	// false false

	// 100 true 2 true 4 false false true -5 false false true -3 true -4 false false
	// true 5 true 6 false false true 7 false false
	public static void main(String[] args) {

		int[] pre = { 10, 20, 70, 30, 40, 50, 60 };
		int[] in = { 20, 70, 10, 40, 50, 30, 60 };
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();

		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(500));
		System.out.println(bt.ht());

		System.out.println(bt.isBalanced());
		System.out.println(bt.isBalanced2());

		// 10 true 30 true 160 false false false true 20 true 40 false false true 50
		// false false
		// BinaryTree other = new BinaryTree();
		// other.display();

		// System.out.println(bt.flipEquivalent(other));

		bt.preorder();
		bt.preorderI();

		System.out.println(bt.maxSubtreeSum2());

	}
}
