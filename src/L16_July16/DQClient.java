package L16_July16;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 16-Jul-2019
 *
 */

public class DQClient {

	public static void main(String[] args) throws Exception {

		DynamicQueue dq = new DynamicQueue();
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);

		System.out.println(dq.dequeue());
		System.out.println(dq.dequeue());

		dq.enqueue(60);
		dq.enqueue(70);
		dq.enqueue(80);

		dq.display();

		System.out.println("-- Actual Reverse --");
		dq.display();
		// actualReverse(dq);
		dq.display();

		System.out.println("-- Display Reverse --");
		dq.display();
		displayReverse(dq, 0);
		dq.display();
	}

	public static void displayReverse(DynamicQueue queue, int count) throws Exception {

		if (count == queue.size()) {
			return;
		}

		int temp = queue.dequeue();
		queue.enqueue(temp);

		displayReverse(queue, count + 1);

		System.out.println(temp);

	}

	public static void actualReverse(DynamicQueue queue) throws Exception {

		if (queue.isEmpty()) {
			return;
		}

		int temp = queue.dequeue();
		actualReverse(queue);
		queue.enqueue(temp);

	}
}
