package chandan449.coursera.algo1.unionfind;

/**
 * Contains common code e.g., initialization of connected components
 * for various implementations of {@link UnionFind}.
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
abstract class AbstractUnionFind implements UnionFind {

	protected int[] nodes;

	public AbstractUnionFind(int numOfElements) {
		this.nodes = new int[numOfElements];
		initConnectedComponents(nodes);
	}

	/**
	 * Initially all nodes are connected to itself and no other nodes.
	 * Hence initializing connected component for each node to contain itself.
	 * In {@link QuickUnion} this can be treated as single identifier for each
	 * connected component, while in {@link QuickUnion} it can be treated as
	 * root of each node in the beginning.<br>
	 * Time complexity of initialization is O(n).
	 */
	private void initConnectedComponents(int[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
		}
	}

}