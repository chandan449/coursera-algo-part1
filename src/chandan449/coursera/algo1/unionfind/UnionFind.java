/**
 * 
 */
package chandan449.coursera.algo1.unionfind;

/**
 * @author ckuma
 *
 */
public interface UnionFind {
	
	public void union(int node1, int node2);
	
	public boolean isConnected(int node1, int node2);

}
