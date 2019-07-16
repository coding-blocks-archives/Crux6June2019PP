package L15_July15;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 15-Jul-2019
 *
 */

public class Stack {

	protected int[] data;
	protected int tos;

	public Stack() {
		data = new int[5];
		tos = -1;
	}

	public Stack(int cap) {
		data = new int[cap];
		tos = -1;
	}

	public void push(int item) throws Exception {

		if (isFull()) {
			throw new Exception("Stack is Full.");
		}

		tos++;
		data[tos] = item;
	}

	public int pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}

		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}

	public int top() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty.");
		}

		int temp = data[tos];
		return temp;
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == data.length;
	}

	public void display() {

		System.out.println("----------------");

		for (int i = tos; i >= 0; i--) {
			System.out.print(data[i] + " ");
		}

		System.out.println(".");
		System.out.println("----------------");

	}

	@Override
	public String toString() {

		String str = "----------------\n";

		for (int i = tos; i >= 0; i--) {
			str += data[i] + " ";
		}

		str += ".\n----------------\n";

		return str;
	}

}
