package quantum.graph;

import java.io.PrintStream;

import quantum.lattice.LatticeFormatter;

public interface Graph {
	/**
	 * Adds an undirected edge to the graph.
	 * @param edge
	 */
	void add(UndirectedEdge edge);

	/**
	 * @return true if graph has an even number of vertices
	 */
	boolean hasEvenNumberOfVertices();

	/**
	 * Outputs a lattice to the specified stream using the specified formatter
	 * @param latticeFormatter
	 * @param stream
	 */
	void outputLattice(LatticeFormatter latticeFormatter, PrintStream stream);
}
