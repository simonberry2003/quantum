package quantum.lattice;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.collect.ImmutableMap;

import lombok.val;
import quantum.bias.BiasBuilder;
import quantum.coupling.CouplingBuilder;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public class DefaultLatticeFormatterTest {

	@Test
	public void testFormat() {

		val vertices = Mockito.mock(Set.class);
		val biasBuilder = Mockito.mock(BiasBuilder.class);
		val biases = ImmutableMap.of(new VertexPair(new Vertex(0), new Vertex(1)), 0);
		Mockito.when(biasBuilder.build(vertices)).thenReturn(biases);

		val couplingBuilder = Mockito.mock(CouplingBuilder.class);
		val couplings = ImmutableMap.of(new VertexPair(new Vertex(1), new Vertex(2)), 1);
		Mockito.when(couplingBuilder.build(vertices)).thenReturn(couplings);

		val baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);

		val formatter = new DefaultLatticeFormatter(biasBuilder, couplingBuilder);
		formatter.format(vertices, out);

		String content = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		Assert.assertEquals("0 1 0" + System.lineSeparator() + "1 2 1" + System.lineSeparator(),  content);
	}

}
