package chandan449.coursera.algo1.unionfind;

/**
 * Improves {@link QuickUnion} by using weighted merge of trees during union.
 * This ensures that tree height can grow to lgN only, avoiding worst case
 * scenario of linear tree.<br>
 * Time complexity of both operations union and find is O(lgN).
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

	/**
	 * Merge strategy is:<br>
	 * 1. Link smaller tree to larger tree root.<br>
	 * 2. For equal size trees we merge 2nd tree to the 1st one.<br>
	 * 3. Update size of new tree.<br>
	 */
	@Override
	void mergeTrees(int root1, int root2) {
		if (lessThan(treeSize[root1], treeSize[root2])) {
			linkFirstTreeToSecondAndUpdateSize(root1, root2);
		}
		else {
			linkFirstTreeToSecondAndUpdateSize(root2, root1);
		}
	}

	private void linkFirstTreeToSecondAndUpdateSize(int root1, int root2) {
		nodes[root1] = root2;
		treeSize[root2] += treeSize[root1];
	}

	private boolean lessThan(int number1, int number2) {
		return  number1 < number2;
	}

	public static void main(String[] args) {
		WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
		weightedQuickUnion.union(4, 1);
		weightedQuickUnion.union(7, 8);
		weightedQuickUnion.union(3, 8);
		weightedQuickUnion.union(8, 9);
		weightedQuickUnion.union(5, 6);
		weightedQuickUnion.union(5, 4);
		weightedQuickUnion.union(9, 0);
		weightedQuickUnion.union(0, 4);
		weightedQuickUnion.union(2, 5);
		String nodes = "";
		for (int i = 0; i < weightedQuickUnion.nodes.length; i++) {
			nodes = nodes + weightedQuickUnion.nodes[i] + " ";
		}
		System.out.println(nodes);
	}

}
