package quantum.problems;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import quantum.Problem;
import quantum.graph.UndirectedEdge;

public class HarderProblem implements Problem {

	/**
	 * 0-1-2-3
	 *   | |
	 * 4-5-6-7
	 */
	@Override
	public Set<UndirectedEdge> getEdges() {
		return ImmutableSet.of(
			new UndirectedEdge(0, 1),
			new UndirectedEdge(1, 2),
			new UndirectedEdge(2, 3),
			new UndirectedEdge(1, 5),
			new UndirectedEdge(2, 6),
			new UndirectedEdge(4, 5),
			new UndirectedEdge(5, 6),
			new UndirectedEdge(6, 7));
	}
}
