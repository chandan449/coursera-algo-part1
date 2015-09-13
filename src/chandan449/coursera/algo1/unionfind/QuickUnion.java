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
		int node1Parent = getParentOf(node1);
		int node2Parent = getParentOf(node2);
		if (node1Parent != node2Parent) {
			nodes[node2Parent] = node1Parent;
		}
	}

	private int getParentOf(int node) {
		while (nodes[node] != node) {
			node = nodes[node];
		}
		return node;
	}

	@Override
	public boolean isConnected(int node1, int node2) {
		return getParentOf(node1) == getParentOf(node2);
	}

}