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

	// O(1)
	public boolean isEmpty() {
		return size == 0;
	}

	// O(1)
	public int getFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty");
		}

		return head.data;

	}

	// O(1)
	public int getLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty");
		}

		return tail.data;

	}

	// O(n)
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

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

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

		return temp;

	}

	// O(n)
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

	// O(1)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		if (size > 0)
			tail.next = nn;

		// data members
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			tail = nn;
			size++;
		}

	}

	// O(1)
	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = head;

		// data members
		if (size == 0) {
			head = tail = nn;
			size++;
		} else {
			head = nn;
			size++;
		}

	}

	// O(n)
	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == size) {
			addLast(item);
		} else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// links
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			// data members
			size++;

		}

	}

	// O(1)
	public int removeFirst() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = head.data;

		if (size == 1) {
			head = tail = null;
			size--;
		} else {
			head = head.next;
			size--;
		}

		return temp;

	}

	// O(n)
	public int removeLast() throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		int temp = tail.data;

		if (size == 1) {
			head = tail = null;
			size--;
		} else {
			Node sm2 = getNodeAt(size - 2);

			// link break
			sm2.next = null;

			// data members update
			tail = sm2;
			size--;

		}
		return temp;

	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size) {
			throw new Exception("Invalid Index");
		}

		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {

			// links
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			// data member
			size--;

			return n.data;

		}

	}

	// O(n^2)
	public void RDI() throws Exception {

		int left = 0;
		int right = size - 1;

		while (left < right) {

			Node ln = getNodeAt(left);
			Node rn = getNodeAt(right);

			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;

			left++;
			right--;
		}

	}

	// O(n)
	public void RPI() {

		Node prev = head;
		Node curr = head.next;

		while (curr != null) {

			Node ahead = curr.next;

			curr.next = prev;

			prev = curr;
			curr = ahead;

		}

		// head tail swap
		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;

	}

	// O(n)
	public void RPR() {
		RPR(head, head.next);

		// head tail swap
		Node temp = head;
		head = tail;
		tail = temp;

		tail.next = null;

	}

	private void RPR(Node prev, Node curr) {

		if (curr == null) {
			return;
		}

		RPR(curr, curr.next);
		curr.next = prev;

		// Node ahead = curr.next ;
		// curr.next = prev;
		// RPR(curr, ahead);

	}

	// O(n)
	public void RDR() {
		// RDR(head, head, 0);

		HeapMover mover = new HeapMover();
		mover.left = head;

		RDRHM(mover, head, 0);

	}

	private Node RDR(Node left, Node right, int count) {

		if (right == null) {
			return left;
		}

		Node cl = RDR(left, right.next, count + 1);

		if (count >= size / 2) {
			int temp = cl.data;
			cl.data = right.data;
			right.data = temp;
		}

		return cl.next;
	}

	private class HeapMover {
		Node left;
	}

	private void RDRHM(HeapMover mover, Node right, int count) {

		if (right == null) {
			return;
		}

		RDRHM(mover, right.next, count + 1);

		if (count >= size / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

}
