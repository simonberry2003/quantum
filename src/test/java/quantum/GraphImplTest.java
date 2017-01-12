package quantum;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;
import quantum.graph.GraphImpl;
import quantum.graph.UndirectedEdge;

public class GraphImplTest {

	@Test
	public void testHasEvenNumberOfVertices() {
		val graph = new GraphImpl();
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
}
