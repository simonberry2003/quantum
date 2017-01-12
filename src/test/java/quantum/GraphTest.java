package quantum;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;

public class GraphTest {

	@Test
	public void testHasEvenNumberOfVertices() {
		val graph = new Graph();
		Assert.assertTrue(graph.hasEvenNumberOfVertices());
		graph.add(new UndirectedEdge(0, 1));
		Assert.assertTrue(graph.hasEvenNumberOfVertices());
		graph.add(new UndirectedEdge(1, 2));
		Assert.assertFalse(graph.hasEvenNumberOfVertices());
		graph.add(new UndirectedEdge(2, 0));
		Assert.assertFalse(graph.hasEvenNumberOfVertices());
		graph.add(new UndirectedEdge(2, 3));
		Assert.assertTrue(graph.hasEvenNumberOfVertices());
	}

	@Test
	public void testGetBiases() {

		val graph = new Graph();
		graph.add(new UndirectedEdge(0, 1));

		val biases = graph.getBiases();
		Assert.assertEquals(2, biases.size());
		Assert.assertEquals(new Integer(0), biases.get(new VertexPair(new Vertex(0), new Vertex(0))));
		Assert.assertEquals(new Integer(0), biases.get(new VertexPair(new Vertex(1), new Vertex(1))));

		graph.add(new UndirectedEdge(1, 2));
		val biases2 = graph.getBiases();
		Assert.assertEquals(3, biases2.size());
		Assert.assertEquals(new Integer(0), biases2.get(new VertexPair(new Vertex(0), new Vertex(0))));
		Assert.assertEquals(new Integer(0), biases2.get(new VertexPair(new Vertex(1), new Vertex(1))));
		Assert.assertEquals(new Integer(0), biases2.get(new VertexPair(new Vertex(2), new Vertex(2))));
	}
}
