package quantum.graph;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import lombok.val;

public class GraphBuilderTest {

	@Test
	public void testBuild() {
		val edge1 = new UndirectedEdge(0, 1);
		val edge2 = new UndirectedEdge(1, 2);
		val edges = ImmutableSet.of(edge1, edge2);
		val builder = new GraphBuilder(edges);
		val graph = builder.build();
		Assert.assertFalse(graph.hasEvenNumberOfVertices());
	}

}
