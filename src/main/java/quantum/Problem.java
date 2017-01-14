package quantum;

import java.util.Set;

import quantum.graph.UndirectedEdge;

/**
 * A problem is defined by list of {@link UndirectedEdge}s
 */
public interface Problem {
	/**
	 * @return the edges for the problem
	 */
	Set<UndirectedEdge> getEdges();
}
