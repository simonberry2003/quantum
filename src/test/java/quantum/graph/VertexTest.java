package quantum.graph;

import org.junit.Assert;
import org.junit.Test;

import lombok.val;

public class VertexTest {

	@Test
	public void testGetId() {
		val vertex = new Vertex(1);
		Assert.assertEquals(1, vertex.getId());
	}

	@Test
	public void testLinkAndIsConnectedTo() {
		val vertex1 = new Vertex(1);
		val vertex2 = new Vertex(2);
		vertex1.link(vertex2);
		Assert.assertTrue(vertex1.isConnectedTo(vertex2));
		Assert.assertTrue(vertex2.isConnectedTo(vertex1));
	}
}
