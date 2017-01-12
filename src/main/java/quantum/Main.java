package quantum;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import lombok.val;

public class Main {

	public static void main(String[] args) {

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

		val biases = graph.getBiases();
		System.out.println("Biases: " + biases);

		val couplings = graph.getCouplings();
		System.out.println("Couplings: " + couplings);

		val combined = new TreeMap<VertexPair, Integer>(biases);
		combined.putAll(couplings);

		for (val latticeLine : combined.entrySet()) {
			System.out.println(latticeLine.getKey().getQubits() + " " + latticeLine.getValue());
		}
	}
}
