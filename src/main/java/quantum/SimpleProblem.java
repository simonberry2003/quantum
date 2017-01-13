package quantum;

import java.util.ArrayList;
import java.util.List;

import quantum.graph.UndirectedEdge;

public class SimpleProblem implements Problem {

	@Override
	public List<UndirectedEdge> getEdges() {
		List<UndirectedEdge> problem = new ArrayList<UndirectedEdge>();
		problem.add(new UndirectedEdge(0, 1));
		problem.add(new UndirectedEdge(1, 3));
		problem.add(new UndirectedEdge(2, 0));
		return problem;
	}
}
