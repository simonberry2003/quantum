package quantum.graph;

import java.io.PrintStream;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import lombok.val;
import quantum.lattice.LatticeFormatter;

public class BasicGraphTest {

	@Test
	public void testHasEvenNumberOfVertices() {

		val graph = new BasicGraph();
		Assert.assertTrue(graph.hasEvenNumberOfVertices());

		graph.addEdge(new UndirectedEdge(0, 1));
		Assert.assertTrue(graph.hasEvenNumberOfVertices());

		graph.addEdge(new UndirectedEdge(1, 2));
		Assert.assertFalse(graph.hasEvenNumberOfVertices());

		graph.addEdge(new UndirectedEdge(2, 0));
		Assert.assertFalse(graph.hasEvenNumberOfVertices());

		graph.addEdge(new UndirectedEdge(2, 3));
		Assert.assertTrue(graph.hasEvenNumberOfVertices());
	}

	@Test
	public void testAddEdge() {

		val vertices = new TreeMap<Integer, Vertex>();
		val graph = new BasicGraph(vertices);

		Assert.assertEquals(0, vertices.size());

		graph.addEdge(new UndirectedEdge(0, 1));
		Assert.assertEquals(2, vertices.size());

		graph.addEdge(new UndirectedEdge(0, 1));
		Assert.assertEquals(2, vertices.size());

		graph.addEdge(new UndirectedEdge(1, 0));
		Assert.assertEquals(2, vertices.size());

		graph.addEdge(new UndirectedEdge(1, 2));
		Assert.assertEquals(3, vertices.size());

		graph.addEdge(new UndirectedEdge(3, 4));
		Assert.assertEquals(5, vertices.size());
	}

	@Test
	public void testOutputLattice() {

		val vertices = new TreeMap<Integer, Vertex>();
		val graph = new BasicGraph(vertices);
		graph.addEdge(new UndirectedEdge(0, 1));

		val formatter = Mockito.mock(LatticeFormatter.class);
		val out = Mockito.mock(PrintStream.class);

		graph.outputLattice(formatter, out);

		val verticesCaptor = ArgumentCaptor.forClass(Set.class);
		val outCaptor = ArgumentCaptor.forClass(PrintStream.class);
		Mockito.verify(formatter).format(verticesCaptor.capture(), outCaptor.capture());

		Assert.assertEquals(2, verticesCaptor.getValue().size());
		Assert.assertTrue(verticesCaptor.getValue().contains(new Vertex(0)));
		Assert.assertTrue(verticesCaptor.getValue().contains(new Vertex(1)));
	}
}
