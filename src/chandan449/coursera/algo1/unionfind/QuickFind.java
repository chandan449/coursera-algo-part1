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

	@Override
	public void union(int node1, int node2) {
		int lastValueAtNode1 = nodes[node1];
		int lastValueAtNode2 = nodes[node2];
		if (lastValueAtNode1 == lastValueAtNode2) {
			// sets are already connected
			return;
		}
		replaceAll(nodes, lastValueAtNode1, lastValueAtNode2);
	}

	private void replaceAll(int[] nodes, int oldValue, int newValue) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == oldValue) {
				nodes[i] = newValue;
			}
		}
	}

	@Override
	public boolean isConnected(int node1, int node2) {
		return nodes[node1] == nodes[node2];
	}

	public static void main(String[] args) {
		QuickFind quickFind = new QuickFind(10);
		quickFind.union(9, 5);
		quickFind.union(8, 7);
		quickFind.union(3, 9);
		quickFind.union(4, 8);
		quickFind.union(7, 0);
		quickFind.union(5, 1);
		String nodes = "";
		for (int i = 0; i < quickFind.nodes.length; i++) {
			nodes = nodes + quickFind.nodes[i] + " ";
		}
		System.out.println(nodes);
	}

}