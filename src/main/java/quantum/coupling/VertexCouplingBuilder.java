package quantum.coupling;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import com.google.common.collect.ImmutableMap;

import lombok.val;
import quantum.graph.Vertex;
import quantum.graph.VertexPair;

@Singleton
public class VertexCouplingBuilder implements CouplingBuilder {

	/**
	 * Builds couplings for the specified vertices. If two vertices are connected they are considered closely coupled.
	 */
	@Override
	public Map<VertexPair, Integer> create(Collection<Vertex> vertices) {
		val couplings = new HashMap<VertexPair, Integer>();
		for (val vertex1 : vertices) {
			for (val vertex2 : vertices) {
				if (vertex2.getId() > vertex1.getId()) {
					couplings.put(new VertexPair(vertex1, vertex2), vertex1.isConnectedTo(vertex2) ? 0 : 1);
				}
			}
		}
		return ImmutableMap.copyOf(couplings);
	}
}
