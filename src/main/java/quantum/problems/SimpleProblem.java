package quantum.problems;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import quantum.Problem;
import quantum.graph.UndirectedEdge;

public class SimpleProblem implements Problem {

	/**
	 * 0-1
	 * | |
	 * 2 3
	 */
	@Override
	public Set<UndirectedEdge> getEdges() {
		return ImmutableSet.of(
			new UndirectedEdge(0, 1),
			new UndirectedEdge(1, 3),
			new UndirectedEdge(2, 0));
	}
}
