package quantum.graph;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.val;

@AllArgsConstructor
public class GraphBuilder {

	private final Set<UndirectedEdge> edges;

	public Graph build() {
		val graph = new BasicGraph();
		for (UndirectedEdge edge : edges) {
			graph.addEdge(edge);
		}
		return graph;
	}
}
