package quantum;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.google.common.base.Preconditions;
import com.google.inject.Guice;

import lombok.val;
import quantum.graph.GraphBuilder;
import quantum.graph.UndirectedEdge;
import quantum.guice.QuantumModule;
import quantum.lattice.LatticeFormatter;

public class Main {

	private final LatticeFormatter latticeFormatter;

	@Inject
	public Main(LatticeFormatter latticeFormatter) {
		this.latticeFormatter = Preconditions.checkNotNull(latticeFormatter);
	}

	public static void main(String[] args) {
		val injector = Guice.createInjector(new QuantumModule());
		val main = injector.getInstance(Main.class);
		main.run();
	}

	private void run() {
		List<UndirectedEdge> problem = new ArrayList<UndirectedEdge>();
		problem.add(new UndirectedEdge(0, 1));
		problem.add(new UndirectedEdge(1, 3));
		problem.add(new UndirectedEdge(2, 0));

//		problem.add(new UndirectedEdge(0, 1));
//		problem.add(new UndirectedEdge(1, 2));
//		problem.add(new UndirectedEdge(2, 3));
//		problem.add(new UndirectedEdge(4, 5));
//		problem.add(new UndirectedEdge(5, 6));
//		problem.add(new UndirectedEdge(6, 7));
//		problem.add(new UndirectedEdge(2, 6));

		val graph = new GraphBuilder(problem).build();
		if (!graph.hasEvenNumberOfVertices()) {
			throw new IllegalStateException("Graph must have even number of vertices");
		};
		System.out.println(graph);

		graph.outputLattice(latticeFormatter, System.out);
	}
}
