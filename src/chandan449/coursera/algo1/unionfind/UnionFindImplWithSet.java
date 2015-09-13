package chandan449.coursera.algo1.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ckuma
 */
public class UnionFindImplWithSet implements UnionFind {
	
	private Map<Integer, Set<Integer>> unionOfSets;

	public UnionFindImplWithSet() {
		unionOfSets = new HashMap<Integer, Set<Integer>>();
	}

	@Override
	public boolean isConnected(int node1, int node2) {
		Set<Integer> node1ConnectedSet =
				unionOfSets.getOrDefault(node1, new HashSet<Integer>());
		return node1ConnectedSet.contains(node2);
	}

	@Override
	public void union(int node1, int node2) {
		Set<Integer> node1ConnectedSet =
				unionOfSets.getOrDefault(node1, new HashSet<Integer>());
		node1ConnectedSet.add(node1);
		Set<Integer> node2ConnectedSet =
				unionOfSets.getOrDefault(node2, new HashSet<Integer>());
		node2ConnectedSet.add(node2);
		node1ConnectedSet.addAll(node2ConnectedSet);
		node2ConnectedSet.addAll(node1ConnectedSet);
		unionOfSets.put(node1, node1ConnectedSet);
		unionOfSets.put(node2, node2ConnectedSet);
	}

}
