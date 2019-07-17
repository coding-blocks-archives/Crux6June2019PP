package L17_July17;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 17-Jul-2019
 *
 */

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	public int getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty");
		}

		return head.data;

	}

	public int getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty");
		}

		return tail.data;

	}

	public int getAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	public void display() {

		System.out.println("--------------------");

		Node temp = head;
		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("--------------------");

	}
}





