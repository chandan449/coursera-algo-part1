package chandan449.coursera.algo1.unionfind;

/**
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public interface UnionFind {
	
	/**
	 * Given two nodes it connects them, i.e., create a single connected
	 * component from two connected components to which each node belongs to.
	 */
	public void union(int node1, int node2);
	/**
	 * @return true if node1 is connected to node2 else false.
	 */
	public boolean connected(int node1, int node2);

}