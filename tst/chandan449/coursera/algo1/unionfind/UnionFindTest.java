package chandan449.coursera.algo1.unionfind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link UnionFind} implementations.
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class UnionFindTest {

	private QuickFind quickFind;
	private QuickUnion quickUnion;
	private WeightedQuickUnion weightedQuickUnion;

	@Before
	public void setUp() {
		quickFind = new QuickFind(10);
		quickUnion = new QuickUnion(10);
		weightedQuickUnion = new WeightedQuickUnion(10);
	}

	@Test
	public void testQuickFind() {
		// no connection yet
		assertFalse(quickFind.connected(1, 2));
		union(quickFind, 4, 3);
		union(quickFind, 3, 8);
		union(quickFind, 6, 5);
		union(quickFind, 9, 4);
		union(quickFind, 2, 1);
		assertFalse(quickFind.connected(0, 7));
		assertTrue(quickFind.connected(8, 9));
	}

	@Test
	public void testQuickUnion() {
		// no connection yet
		assertFalse(quickUnion.connected(1, 2));
		union(quickUnion, 4, 3);
		union(quickUnion, 3, 8);
		union(quickUnion, 6, 5);
		union(quickUnion, 9, 4);
		union(quickUnion, 2, 1);
		assertFalse(quickUnion.connected(0, 7));
		assertTrue(quickUnion.connected(8, 9));
	}

	@Test
	public void testWeightedQuickUnion() {
		// no connection yet
		assertFalse(weightedQuickUnion.connected(1, 2));
		union(weightedQuickUnion, 4, 3);
		union(weightedQuickUnion, 3, 8);
		union(weightedQuickUnion, 6, 5);
		union(weightedQuickUnion, 9, 4);
		union(weightedQuickUnion, 2, 1);
		assertFalse(weightedQuickUnion.connected(0, 7));
		assertTrue(weightedQuickUnion.connected(8, 9));
	}

	private void union(UnionFind unionFind, int n1, int n2) {
		unionFind.union(n1, n2);
	}

}