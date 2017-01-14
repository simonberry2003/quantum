package quantum.graph;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public class VertexPairTest {

	@Test
	public void testGetIds() {
		val pair = new VertexPair(new Vertex(1), new Vertex(2));
		Assert.assertEquals("1 2", pair.getIds());
	}

	@Test
	public void testCompareTo() {
		val pair1 = new VertexPair(new Vertex(1), new Vertex(2));
		val pair2 = new VertexPair(new Vertex(2), new Vertex(3));
		val pair3 = new VertexPair(new Vertex(2), new Vertex(4));
		Assert.assertEquals(0, pair1.compareTo(pair1));
		Assert.assertEquals(-1, pair1.compareTo(pair2));
		Assert.assertEquals(1, pair2.compareTo(pair1));
		Assert.assertEquals(-1, pair2.compareTo(pair3));
		Assert.assertEquals(1, pair3.compareTo(pair2));
	}
}
