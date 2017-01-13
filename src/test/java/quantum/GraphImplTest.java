package quantum;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;
import quantum.graph.BasicGraph;
import quantum.graph.UndirectedEdge;

public class GraphImplTest {

	@Test
	public void testHasEvenNumberOfVertices() {
		val graph = new BasicGraph();
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
