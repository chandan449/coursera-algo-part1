package chandan449.coursera.algo1.unionfind;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class QuickUnion extends AbstractUnionFind {

	public QuickUnion(int numOfElements) {
		super(numOfElements);
	}

	@Override
	public void union(int node1, int node2) {
		mergeTrees(rootOf(node1), rootOf(node2));
	}

	void mergeTrees(int root1, int root2) {
		if (root1 != root2) {
			nodes[root2] = root1;
		}
	}

	int rootOf(int node) {
		while (nodes[node] != node) {
			node = nodes[node];
		}
		return node;
	}

	@Override
	public boolean connected(int node1, int node2) {
		return rootOf(node1) == rootOf(node2);
	}

}