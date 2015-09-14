package chandan449.coursera.algo1.unionfind;

/**
 * Improves {@link QuickUnion} by using weighted merge of trees during union.
 * This ensures that tree height can grow to logN only, avoiding worst case
 * scenario of linear tree.
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class WeightedQuickUnion extends QuickUnion {

	protected int[] treeSize;

	public WeightedQuickUnion(int numOfElements) {
		super(numOfElements);
		this.treeSize = new int[numOfElements];
		initTreeSize(treeSize);
	}

	/**
	 * Initially all nodes are single element tree rooted at itself.
	 * Hence initialize size of each tree to 1.
	 */
	private void initTreeSize(int[] treeSize) {
		for (int i = 0; i < treeSize.length; i++) {
			treeSize[i] = 1;
		}
	}

	@Override
	void mergeTrees(int root1, int root2) {
		if (lessThan(treeSize[root2], treeSize[root1])) {
			nodes[root2] = root1;
			treeSize[root1] += treeSize[root2];
		}
		else {
			nodes[root1] = root2;
			treeSize[root2] += treeSize[root1];
		}
	}

	private boolean lessThan(int number1, int number2) {
		return  number1 < number2;
	}

	public static void main(String[] args) {
		WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
		weightedQuickUnion.union(7, 9);
		weightedQuickUnion.union(7, 6);
		weightedQuickUnion.union(3, 8);
		weightedQuickUnion.union(9, 5);
		weightedQuickUnion.union(4, 1);
		weightedQuickUnion.union(9, 2);
		weightedQuickUnion.union(8, 4);
		weightedQuickUnion.union(8, 5);
		weightedQuickUnion.union(0, 1);
		String nodes = "";
		for (int i = 0; i < weightedQuickUnion.nodes.length; i++) {
			nodes = nodes + weightedQuickUnion.nodes[i] + " ";
		}
		System.out.println(nodes);
	}

}
