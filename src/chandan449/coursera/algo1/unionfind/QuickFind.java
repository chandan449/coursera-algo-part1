package chandan449.coursera.algo1.unionfind;

/**
 * Union is O(n) and find is O(1).
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class QuickFind implements UnionFind {

	private int[] nodes;
	private int numOfElements;

	public QuickFind(int numOfElements) {
		this.numOfElements = numOfElements;
		this.nodes = new int[numOfElements];
		initConnectedSets(nodes);
	}

	private void initConnectedSets(int[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
		}
	}

	@Override
	public void union(int node1, int node2) {
		int lastValueAtNode1 = nodes[node1];
		int lastValueAtNode2 = nodes[node2];
		if (lastValueAtNode1 == lastValueAtNode2) {
			// sets are already connected
			return;
		}
		replaceAll(lastValueAtNode2, lastValueAtNode1);
	}

	private void replaceAll(int oldValue, int newValue) {
		for (int i = 0; i < numOfElements; i++) {
			if (nodes[i] == oldValue) {
				nodes[i] = newValue;
			}
		}
	}

	@Override
	public boolean isConnected(int node1, int node2) {
		return nodes[node1] == nodes[node2];
	}

}