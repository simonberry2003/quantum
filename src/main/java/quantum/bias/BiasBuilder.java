package quantum.bias;

import java.util.Map;
import java.util.Set;

import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public interface BiasBuilder {
	/**
	 * Builds a map of biases for each vertex pair in the list of vertices
	 * @param vertices
	 * @return biases
	 */
	Map<VertexPair, Integer> build(Set<Vertex> vertices);
}
