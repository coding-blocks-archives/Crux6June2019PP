package L20_July22;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 22-Jul-2019
 *
 */

public class GTClient {

	public static void main(String[] args) {

		// 10 3 20 2 50 0 60 0 30 0 40 2 70 0 80 0
		// 10 3 20 3 50 2 100 0 110 0 60 0 70 2 120 2 160 0 170 0 130 0 30 0 40 2 80 0 90 2 140 2 180 0 190 0 150 0
		GenericTree gt = new GenericTree();
		gt.display();

		// System.out.println(gt.size());
		// System.out.println(gt.max());
		// System.out.println(gt.find(60));
		// System.out.println(gt.ht());
		// gt.mirror();
		// gt.display();

		// gt.printAtLevel(2);
		// gt.linearize();
		// gt.display();
		//
		// gt.preorder();
		//
		// gt.postorder();

		// gt.levelOrder();
		// gt.levelOrderLW2();
		gt.levelOrderZZ();

	}
}
