package chandan449.coursera.algo1.unionfind;


/**
 * Union is O(n) and find is O(1).
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class QuickFind extends AbstractUnionFind implements UnionFind {

	public QuickFind(int numOfElements) {
		super(numOfElements);
	}

	/**
	 * In context of {@link QuickFind} connecting nodes mean creating
	 * union of two given connected components. Each component is identified by
	 * an index number. When creating union we assign the same identifier to
	 * each connected components. We do this by replacing identifier of the 1st
	 * connected component with the identifier of 2nd connected component.<br>
	 * Time complexity of union is O(n).
	 */
	@Override
	public void union(int node1, int node2) {
		if (!connected(node1, node2)) {
			connect(nodes, nodes[node1], nodes[node2]);
		}
	}

	private void connect(int[] nodes, int oldValue, int newValue) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == oldValue) {
				nodes[i] = newValue;
			}
		}
	}

	/**
	 * In {@link QuickFind} checking if 2 nodes are connected is finding out
	 * the connected components to which each node belongs to.<br>
	 * Time complexity of this operation is O(1).
	 */
	@Override
	public boolean connected(int node1, int node2) {
		return nodes[node1] == nodes[node2];
	}

	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(10);
		quickFind.union(8, 5);
		quickFind.union(9, 4);
		quickFind.union(1, 5);
		quickFind.union(7, 0);
		quickFind.union(9, 3);
		quickFind.union(8, 3);
		String nodes = "";
		for (int i = 0; i < quickFind.nodes.length; i++) {
			nodes = nodes + quickFind.nodes[i] + " ";
		}
		System.out.println(nodes);
	}

}