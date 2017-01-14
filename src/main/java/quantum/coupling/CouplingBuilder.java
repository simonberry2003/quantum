package quantum.coupling;

import java.util.Map;
import java.util.Set;

import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public interface CouplingBuilder {
	/**
	 * Builds a map of couplings between each vertex pair in the list of vertices
	 * @param vertices
	 * @return couplings
	 */
	Map<VertexPair, Integer> build(Set<Vertex> vertices);
}
