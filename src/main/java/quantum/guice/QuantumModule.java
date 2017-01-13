package quantum.guice;

import com.google.inject.AbstractModule;

import quantum.DefaultProblemProvider;
import quantum.ProblemProvider;
import quantum.bias.BiasBuilder;
import quantum.bias.ZeroBiasBuilder;
import quantum.coupling.CouplingBuilder;
import quantum.coupling.VertexCouplingBuilder;
import quantum.lattice.DefaultLatticeFormatter;
import quantum.lattice.LatticeFormatter;

/**
 * Guice configuration module for injected classes
 */
public class QuantumModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(BiasBuilder.class).to(ZeroBiasBuilder.class);
		bind(CouplingBuilder.class).to(VertexCouplingBuilder.class);
		bind(LatticeFormatter.class).to(DefaultLatticeFormatter.class);
		bind(ProblemProvider.class).to(DefaultProblemProvider.class);
	}
}
