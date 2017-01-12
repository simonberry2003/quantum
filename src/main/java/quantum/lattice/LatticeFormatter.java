package quantum.lattice;

import java.io.PrintStream;
import java.util.Collection;

import quantum.graph.Vertex;

public interface LatticeFormatter {
	void format(Collection<Vertex> vertices, PrintStream out);
}
