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

		// int[] pre = { 10, 500, 30, 60, 55, 70, 20, 150, 300, 250, 400, 500 };
		// int[] in = { 30, 500, 55, 60, 70, 10, 150, 20, 250, 300, 400, 500 };

		int[] pre = { 10, 20, 40, 120, 100, 50, 80, 130, 30, 60, 70, 90 };
		int[] in = { 120, 40, 100, 20, 50, 80, 130, 10, 60, 30, 90, 70 };
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

		System.out.println(bt.isTreeBST());

		bt.verticalDisplay();

	}
}
