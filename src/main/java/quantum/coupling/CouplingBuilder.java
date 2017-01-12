package quantum.coupling;

import java.util.Collection;
import java.util.Map;

import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public interface CouplingBuilder {
	Map<VertexPair, Integer> build(Collection<Vertex> vertices);
}
