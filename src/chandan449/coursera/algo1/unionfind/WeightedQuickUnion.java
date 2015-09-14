package chandan449.coursera.algo1.unionfind;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class WeightedQuickUnion extends QuickUnion {
	
	protected int[] weights;

	public WeightedQuickUnion(int numOfElements) {
		super(numOfElements);
		this.weights = new int[numOfElements];
		initWeights(weights);
	}
	
	private void initWeights(int[] weights) {
		for (int i = 0; i < weights.length; i++) {
			weights[i] = 1;
		}
	}
	
	@Override
	public void union(int node1, int node2) {
		int node1Parent = getParentOf(node1);
		int node2Parent = getParentOf(node2);
		int weight1 = weights[node1Parent];
		int weight2 = weights[node2Parent];
		if (weight1 >= weight2) {
			nodes[node1Parent] = node2Parent;
			weights[node2Parent] = weight1 + weight2;
		}
		else {
			nodes[node2Parent] = node1Parent;
			weights[node1Parent] = weight1 + weight2;
		}
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
