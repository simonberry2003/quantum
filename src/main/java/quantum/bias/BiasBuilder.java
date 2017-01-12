package quantum.bias;

import java.util.Collection;
import java.util.Map;

import quantum.graph.Vertex;
import quantum.graph.VertexPair;

public interface BiasBuilder {
	Map<VertexPair, Integer> build(Collection<Vertex> vertices);
}
