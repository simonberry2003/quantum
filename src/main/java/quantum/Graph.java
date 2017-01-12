package quantum;

import java.util.Map;
import java.util.TreeMap;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

import lombok.ToString;
import lombok.val;

/**
 * A graph is a container class for a number of {@link Vertex}.
 */
@ToString
public class Graph {

	/**
	 * The vertices in the graph ordered by id
	 */
	private final Map<Integer, Vertex> vertices = new TreeMap<>();

	/**
	 * Adds an undirected edge to the graph. This creates a new vertex for each
	 * end of the edge if one does not already exist and links the two vertices
	 * together.
	 * @param edge
	 */
	public void add(UndirectedEdge edge) {
		Preconditions.checkNotNull(edge);
		val vertex1 = getOrCreateVertex(edge.getVertex1());
		val vertex2 = getOrCreateVertex(edge.getVertex2());
		vertex1.link(vertex2);
	}

	private Vertex getOrCreateVertex(int vertex) {
		if (!vertices.containsKey(vertex)) {
			vertices.put(vertex, new Vertex(vertex));
		}
		return vertices.get(vertex);
	}

	/**
	 * @return true if graph has an even number of vertices
	 */
	public boolean hasEvenNumberOfVertices() {
		return vertices.size() % 2 == 0;
	}

	/**
	 * @return the biases for each vertex in the graph
	 */
	public Map<VertexPair, Integer> getBiases() {
		val biases = new TreeMap<VertexPair, Integer>();
		for (val vertex : vertices.values()) {
			biases.put(new VertexPair(vertex, vertex), 0);
		}
		return ImmutableMap.copyOf(biases);
	}

	/**
	 * Determine the couplings for each unique combination of vertices.
	 * If a pair of vertices are connected, the coupling is 0, otherwise 1.
	 * @return the couplings
	 */
	public Map<VertexPair, Integer> getCouplings() {
		val couplings = new TreeMap<VertexPair, Integer>();
		for (val vertex1 : vertices.values()) {
			for (val vertex2 : vertices.values()) {
				if (vertex2.getId() > vertex1.getId()) {
					couplings.put(new VertexPair(vertex1, vertex2), vertex1.isConnectedTo(vertex2) ? 0 : 1);
				}
			}
		}
		return ImmutableMap.copyOf(couplings);
	}
}
