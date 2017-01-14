package quantum.bias;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableMap;

import lombok.val;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

@Singleton
public class ZeroBiasBuilder implements BiasBuilder {

	/**
	 * Build biases for the specified vertices with a zero value.
	 */
	@Override
	public Map<VertexPair, Integer> build(Set<Vertex> vertices) {
		val biases = new HashMap<VertexPair, Integer>();
		for (val vertex : vertices) {
			biases.put(new VertexPair(vertex, vertex), 0);
		}
		return ImmutableMap.copyOf(biases);
	}
}
