package L32_Aug4;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 04-Aug-2019
 *
 */

public class GraphClient {

	public static void main(String[] args) {

		Graph gp = new Graph(7);
		gp.addEdge(1, 2, 3);
		gp.addEdge(1, 3, 2);
		gp.addEdge(2, 4, 8);
		gp.addEdge(2, 5, 1);
		gp.addEdge(3, 4, 5);
		gp.addEdge(5, 6, 6);
		gp.addEdge(5, 7, 7);
		gp.addEdge(6, 7, 1);
		gp.removeEdge(2, 5);
		System.out.println(gp);
		//
		// System.out.println(gp.numEdges());
		// System.out.println(gp.containsEdge(1, 6));
		//
		// System.out.println(gp.hasPath(1, 6));
		// gp.hasAllPath(1, 6);
		// System.out.println(gp.BFS(1, 6));
		gp.BFT();

	}
}
