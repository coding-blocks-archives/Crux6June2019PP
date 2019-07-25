package L24_July25;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 25-Jul-2019
 *
 */

public class BSTClient {

	public static void main(String[] args) {

		int[] in = { 10, 20, 30, 40, 50, 60, 70 };
		BST bst = new BST(in);
		bst.display();

		System.out.println(bst.size());
		System.out.println(bst.max());
		System.out.println(bst.ht());
		System.out.println(bst.find(4));

		// bst.printInRange(15, 55);

//		bst.replaceWithSumLarger();

		bst.display();
		
		bst.add(32);
		bst.add(35); 
		bst.add(29) ;
		bst.display();
	}
}
