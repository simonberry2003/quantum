package quantum.coupling;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import lombok.val;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public class VertexCouplingBuilderTest {

	@Test
	public void testBuildForTwoLinkedVertices() {

		val vertex1 = new Vertex(0);
		val vertex2 = new Vertex(1);
		vertex1.link(vertex2);

		val vertices = ImmutableSet.of(vertex1, vertex2);

		val builder = new VertexCouplingBuilder();
		val couplings = builder.build(vertices);

		Assert.assertEquals(1, couplings.size());
		Assert.assertEquals(new Integer(0), couplings.get(new VertexPair(vertex1, vertex2)));
	}

	@Test
	public void testBuildForFourVerticesWithTwoLinks() {

		val vertex1 = new Vertex(0);
		val vertex2 = new Vertex(1);
		vertex1.link(vertex2);
		val vertex3 = new Vertex(2);
		val vertex4 = new Vertex(3);
		vertex3.link(vertex4);

		val vertices = ImmutableSet.of(vertex1, vertex2, vertex3, vertex4);

		val builder = new VertexCouplingBuilder();
		val couplings = builder.build(vertices);

		Assert.assertEquals(6, couplings.size());
		Assert.assertEquals(new Integer(0), couplings.get(new VertexPair(vertex1, vertex2)));
		Assert.assertEquals(new Integer(1), couplings.get(new VertexPair(vertex1, vertex3)));
		Assert.assertEquals(new Integer(1), couplings.get(new VertexPair(vertex1, vertex4)));
		Assert.assertEquals(new Integer(1), couplings.get(new VertexPair(vertex2, vertex3)));
		Assert.assertEquals(new Integer(1), couplings.get(new VertexPair(vertex2, vertex4)));
		Assert.assertEquals(new Integer(0), couplings.get(new VertexPair(vertex3, vertex4)));
	}
}

