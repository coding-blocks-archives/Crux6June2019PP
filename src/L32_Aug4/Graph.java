package L32_Aug4;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2019
 *
 */

public class Graph {

	int numV;
	int[][] matrix;

	public Graph() {

		this(5);

	}

	public Graph(int N) {

		numV = N;
		matrix = new int[N + 1][N + 1];
	}

	public void addEdge(int u, int v, int c) {
		// Undirected
		matrix[u][v] = c;
		matrix[v][u] = c;
	}

	public int removeEdge(int u, int v) {

		int temp = matrix[u][v];
		matrix[u][v] = 0;
		matrix[v][u] = 0;

		return temp;
	}

	public int numEdges() {

		int cnt = 0;

		for (int i = 1; i <= numV; i++) {

			for (int j = 1; j <= numV; j++) {

				if (matrix[i][j] != 0) {
					cnt++;
				}
			}
		}

		return cnt / 2;

	}

	public boolean containsEdge(int u, int v) {

		return matrix[u][v] != 0;
	}

	@Override
	public String toString() {

		for (int i = 1; i <= numV; i++) {

			System.out.print(i + "-> ");
			for (int j = 1; j <= numV; j++) {

				if (matrix[i][j] != 0)
					System.out.print(j + "[" + matrix[i][j] + "], ");
			}
			System.out.println();
		}
		return "";
	}

	public boolean hasPath(int u, int v) {

		HashMap<Integer, Boolean> visited = new HashMap<>();
		return hasPath(u, v, visited, "");
	}

	private boolean hasPath(int src, int dst, HashMap<Integer, Boolean> visited, String asf) {

		if (containsEdge(src, dst)) {
			System.out.print(asf + src + dst);
			return true;
		}

		visited.put(src, true);

		for (int nbr = 1; nbr < matrix[0].length; nbr++) {

			if (!visited.containsKey(nbr) && containsEdge(src, nbr)) {
				boolean ans = hasPath(nbr, dst, visited, asf + src);
				if (ans) {
					return true;
				}
			}
		}

		return false;

	}

	public void hasAllPath(int u, int v) {

		HashMap<Integer, Boolean> visited = new HashMap<>();
		hasAllPath(u, v, visited, "");
	}

	private void hasAllPath(int src, int dst, HashMap<Integer, Boolean> visited, String asf) {

		if (src == dst) {
			System.out.println(asf + dst);

			return;
		}

		visited.put(src, true);

		for (int nbr = 1; nbr < matrix[0].length; nbr++) {

			if (!visited.containsKey(nbr) && matrix[src][nbr] != 0) {
				hasAllPath(nbr, dst, visited, asf + src);

			}
		}

		visited.remove(src);

	}

	class pair {

		int data;
		String asf;

		pair(int d, String s) {
			data = d;
			asf = s;
		}
	}

	public boolean BFS(int src, int dst) {

		LinkedList<pair> q = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();

		pair np = new pair(src, "");
		q.addLast(np);
		while (!q.isEmpty()) {

			pair rp = q.removeFirst();

			if (visited.containsKey(rp.data)) {
				continue;
			}

			if (containsEdge(rp.data, dst)) {
				System.out.println(rp.asf + rp.data + dst + " ");
				return true;
			}

			visited.put(rp.data, true);

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (!visited.containsKey(nbr) && containsEdge(rp.data, nbr)) {
					q.addLast(new pair(nbr, rp.asf + rp.data));
				}
			}

		}

		return false;
	}

	public void BFT() {

		LinkedList<pair> q = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();

		for (int src = 1; src <= numV; src++) {

			if (visited.containsKey(src)) {
				continue;
			}
			pair np = new pair(src, src + "");
			q.addLast(np);
			while (!q.isEmpty()) {

				pair rp = q.removeFirst();

				if (visited.containsKey(rp.data)) {
					continue;
				}

				System.out.println(rp.data + " Coming via " + rp.asf + " ");

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (!visited.containsKey(nbr) && containsEdge(rp.data, nbr)) {
						q.addLast(new pair(nbr, rp.asf + nbr));
					}
				}

			}

		}
	}

	public boolean DFS(int src, int dst) {

		LinkedList<pair> stack = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();

		pair np = new pair(src, "");
		stack.addFirst(np);
		while (!stack.isEmpty()) {

			pair rp = stack.removeFirst();

			if (visited.containsKey(rp.data)) {
				continue;
			}

			if (containsEdge(rp.data, dst)) {
				System.out.println(rp.asf + rp.data + dst + " ");
				return true;
			}

			visited.put(rp.data, true);

			for (int nbr = 1; nbr <= numV; nbr++) {

				if (!visited.containsKey(nbr) && containsEdge(rp.data, nbr)) {
					stack.addFirst(new pair(nbr, rp.asf + rp.data));
				}
			}

		}

		return false;
	}

	public void DFT() {

		LinkedList<pair> stack = new LinkedList<>();
		HashMap<Integer, Boolean> visited = new HashMap<>();

		for (int src = 1; src <= numV; src++) {

			if (visited.containsKey(src)) {
				continue;
			}

			pair np = new pair(src, "");
			stack.addFirst(np);
			while (!stack.isEmpty()) {

				pair rp = stack.removeFirst();

				if (visited.containsKey(rp.data)) {
					continue;
				}

				System.out.println(rp.data + " Coming via " + rp.asf + " ");

				visited.put(rp.data, true);

				for (int nbr = 1; nbr <= numV; nbr++) {

					if (!visited.containsKey(nbr) && containsEdge(rp.data, nbr)) {
						stack.addFirst(new pair(nbr, rp.asf + rp.data));
					}
				}

			}
		}

	}

}
