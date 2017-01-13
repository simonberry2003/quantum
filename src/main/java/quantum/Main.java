package quantum;

import javax.inject.Inject;

import com.google.common.base.Preconditions;
import com.google.inject.Guice;

import lombok.val;
import quantum.graph.GraphBuilder;
import quantum.guice.QuantumModule;
import quantum.lattice.LatticeFormatter;

public class Main {

	private final LatticeFormatter latticeFormatter;
	private final ProblemProvider problemProvider;

	@Inject
	public Main(LatticeFormatter latticeFormatter, ProblemProvider problemProvider) {
		this.latticeFormatter = Preconditions.checkNotNull(latticeFormatter);
		this.problemProvider = Preconditions.checkNotNull(problemProvider);
	}

	public static void main(String[] args) {
		val injector = Guice.createInjector(new QuantumModule());
		val main = injector.getInstance(Main.class);
		main.run();
	}

	private void run() {
		val problem = problemProvider.get();
		val graph = new GraphBuilder(problem.getEdges()).build();
		if (!graph.hasEvenNumberOfVertices()) {
			throw new IllegalStateException("Graph must have even number of vertices");
		};
		System.out.println(graph);

		graph.outputLattice(latticeFormatter, System.out);
	}
}
