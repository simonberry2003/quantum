package quantum.graph;

import java.io.PrintStream;
import java.util.TreeMap;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;

import lombok.ToString;
import lombok.val;
import quantum.lattice.LatticeFormatter;

/**
 * A graph is a container class for a number of {@link Vertex}.
 */
@ToString
public class BasicGraph implements Graph {

	/**
	 * The vertices in the graph ordered by id
	 */
	private final TreeMap<Integer, Vertex> vertices;

	public BasicGraph() {
		this(new TreeMap<Integer, Vertex>());
	}

	public BasicGraph(TreeMap<Integer, Vertex> vertices) {
		this.vertices = Preconditions.checkNotNull(vertices);
	}

	/**
	 * Creates a new vertex for each end of the edge if one does not already exist and
	 * links the two vertices together.
	 * @param edge
	 */
	@Override
	public void addEdge(UndirectedEdge edge) {
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

	@Override
	public boolean hasEvenNumberOfVertices() {
		return vertices.size() % 2 == 0;
	}

	@Override
	public void outputLattice(LatticeFormatter formatter, PrintStream out) {
		formatter.format(ImmutableSet.copyOf(vertices.values()), out);
	}
}
