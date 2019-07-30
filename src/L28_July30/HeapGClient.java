package L28_July30;

import java.util.ArrayList;

import L25_July26.GenericsFxn.Car;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2019
 *
 */

public class HeapGClient {

	public static void main(String[] args) {

		HeapGeneric<Car> heapg = new HeapGeneric<>();

		Car[] carr = new Car[5];

		carr[0] = new Car(100, 20, "Black");
		carr[1] = new Car(200, 10, "White");
		carr[2] = new Car(50, 5, "Red");
		carr[3] = new Car(80, 7, "Grey");
		carr[4] = new Car(20, 3, "Brown");

		for (int i = 0; i < 5; i++) {
			heapg.add(carr[i]);
		}

		while (!heapg.isEmpty()) {
			System.out.println(heapg.remove());
		}

		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());
		lists.add(new ArrayList<>());

		lists.get(0).add(1);
		lists.get(0).add(8);
		lists.get(0).add(9);
		lists.get(0).add(10);
		lists.get(0).add(12);

		lists.get(1).add(5);
		lists.get(1).add(15);
		lists.get(1).add(20);

		lists.get(2).add(7);
		lists.get(2).add(13);
		lists.get(2).add(25);
		lists.get(2).add(30);

		lists.get(3).add(2);
		lists.get(3).add(3);

		System.out.println(mergeKSortedLists(lists));

		int[] arr = { 12, 10, 5, 6, 20, 4, 3, 40 };
		kLargestElements(arr, 3);
	}

	public static class Pair implements Comparable<Pair> {
		int data;
		int listNo;
		int idxNo;

		@Override
		public int compareTo(Pair o) {
			return o.data - this.data;
		}
	}

	public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < lists.size(); i++) {
			Pair np = new Pair();
			np.data = lists.get(i).get(0);
			np.idxNo = 0;
			np.listNo = i;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			ans.add(rp.data);

			rp.idxNo++;

			if (rp.idxNo < lists.get(rp.listNo).size()) {
				rp.data = lists.get(rp.listNo).get(rp.idxNo);
				heap.add(rp);
			}

		}

		return ans;

	}

	public static void kLargestElements(int[] arr, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}

		for (int i = k; i < arr.length; i++) {

			int weakest = heap.get();

			if (arr[i] > weakest) {
				heap.remove();
				heap.add(arr[i]);
			}

		}

		while (!heap.isEmpty()) {
			System.out.println(heap.remove());
		}

	}

}
