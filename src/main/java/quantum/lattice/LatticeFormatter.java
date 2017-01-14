package quantum.lattice;

import java.io.PrintStream;
import java.util.Set;

import quantum.graph.Vertex;

public interface LatticeFormatter {
	/**
	 * Format the vertex lattices and output the specified stream
	 * @param vertices
	 * @param out
	 */
	void format(Set<Vertex> vertices, PrintStream out);
}
