package quantum.lattice;

import java.io.PrintStream;
import java.util.Collection;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.google.common.base.Preconditions;

import lombok.val;
import quantum.bias.BiasBuilder;
import quantum.coupling.CouplingBuilder;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

@Singleton
public class DefaultLatticeFormatter implements LatticeFormatter {

	private final BiasBuilder biasBuilder;
	private final CouplingBuilder couplingBuilder;

	@Inject
	public DefaultLatticeFormatter(BiasBuilder biasBuilder, CouplingBuilder couplingBuilder) {
		this.biasBuilder = Preconditions.checkNotNull(biasBuilder);
		this.couplingBuilder = Preconditions.checkNotNull(couplingBuilder);
	}

	@Override
	public void format(Collection<Vertex> vertices, PrintStream out) {
		val biases = biasBuilder.create(vertices);
		val couplings = couplingBuilder.create(vertices);
		val combined = new TreeMap<VertexPair, Integer>(biases);
		combined.putAll(couplings);
		for (val line : combined.entrySet()) {
			out.println(line.getKey().getIds() + " " + line.getValue());
		}
	}
}
