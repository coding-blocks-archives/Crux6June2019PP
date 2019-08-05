package L32_Aug4 ;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQ_demo {

	public static void main(String[] args) {

		// Min_Heap
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();

		// Max_Heap
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());

		// PairType - PriorityQueue - External Comparator
		PriorityQueue<demo_pair> pq3 = new PriorityQueue<>(new pairComp());

		// PairType - PriorityQueue - Inplace
		PriorityQueue<demo_pair> pq4 = new PriorityQueue<>(new Comparator<demo_pair>() {

			@Override
			public int compare(demo_pair o1, demo_pair o2) {
				// TODO Auto-generated method stub
				return o1.a - o2.a;
			}
		});
	}
	
	//Pair Type Class
	static class demo_pair {

		int a;
		int b;
	}

	// Manual Comparator
	static class pairComp implements Comparator<demo_pair> {

		@Override
		public int compare(demo_pair o1, demo_pair o2) {

			return o1.a - o2.a;
		}

	}
}
