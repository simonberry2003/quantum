package quantum.bias;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import lombok.val;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public class ZeroBiasBuilderTest {

	@Test
	public void testBuild() {

		val vertex1 = new Vertex(0);
		val vertex2 = new Vertex(1);
		val vertex3 = new Vertex(2);
		val vertices = ImmutableSet.of(vertex1, vertex2, vertex3);

		val builder = new ZeroBiasBuilder();
		val biases = builder.build(vertices);

		Assert.assertEquals(3, biases.size());
		Assert.assertEquals(new Integer(0), biases.get(new VertexPair(vertex1, vertex1)));
		Assert.assertEquals(new Integer(0), biases.get(new VertexPair(vertex2, vertex2)));
		Assert.assertEquals(new Integer(0), biases.get(new VertexPair(vertex3, vertex3)));
	}
}

