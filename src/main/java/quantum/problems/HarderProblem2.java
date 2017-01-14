package quantum.problems;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import quantum.Problem;
import quantum.graph.UndirectedEdge;

public class HarderProblem2 implements Problem {

	/**
	 *   1 - 2
	 *  / \ / \
	 * 0 - 3 - 4
	 *     |
	 *     5 - 8
	 *    / \ / \
	 *   6 - 7 - 9
	 */
	@Override
	public Set<UndirectedEdge> getEdges() {
		return ImmutableSet.of(
			new UndirectedEdge(0, 1),
			new UndirectedEdge(0, 3),
			new UndirectedEdge(1, 2),
			new UndirectedEdge(1, 3),
			new UndirectedEdge(2, 3),
			new UndirectedEdge(2, 4),
			new UndirectedEdge(3, 4),
			new UndirectedEdge(3, 5),
			new UndirectedEdge(5, 6),
			new UndirectedEdge(5, 7),
			new UndirectedEdge(5, 8),
			new UndirectedEdge(6, 7),
			new UndirectedEdge(7, 8),
			new UndirectedEdge(7, 9),
			new UndirectedEdge(8, 9)
		);
	}
}
