package chandan449.coursera.algo1.unionfind;

abstract class AbstractUnionFind implements UnionFind {

	protected int[] nodes;

	public AbstractUnionFind(int numOfElements) {
		this.nodes = new int[numOfElements];
		initConnectedSets(nodes);
	}

	private void initConnectedSets(int[] nodes) {
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = i;
		}
	}

}