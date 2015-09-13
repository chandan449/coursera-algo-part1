package chandan449.coursera.algo1.unionfind;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link UnionFind}
 *
 * @author Chandan Kumar (chandan449@gmail.com)
 */
public class UnionFindTest {
	
	private UnionFind unionFind;

	@Before
	public void setUp() {
		unionFind = new QuickFind(10);
	}

	@Test
	public void testUnionFind() {
		// no connection yet
		assertFalse(unionFind.isConnected(1, 2));
		union(4, 3);
		union(3, 8);
		union(6, 5);
		union(9, 4);
		union(2, 1);
		assertFalse(unionFind.isConnected(0, 7));
		assertTrue(unionFind.isConnected(8, 9));
	}
	
	private void union(int n1, int n2) {
		unionFind.union(n1, n2);
	}

}