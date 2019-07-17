package L17_July17.Adapters;

import L16_July16.DynamicStack;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class QueueUsingStackDeqEff {

	DynamicStack primary = new DynamicStack();

	public void enqueue(int item) throws Exception {

		try {
			DynamicStack helper = new DynamicStack();

			while (!primary.isEmpty()) {
				helper.push(primary.pop());
			}

			helper.push(item);

			while (!helper.isEmpty()) {
				primary.push(helper.pop());
			}
		} catch (Exception e) {
			throw new Exception("Queue is Full.");
		}

	}

	public int dequeue() throws Exception {

		try {
			return primary.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}
	}

	public int getFront() throws Exception {

		try {
			return primary.top();
		} catch (Exception e) {
			throw new Exception("Queue is Empty.");
		}

	}

	public void display() {
		primary.display();
	}

}
