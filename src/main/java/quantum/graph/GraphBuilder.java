package quantum.graph;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GraphBuilder {

	private final List<UndirectedEdge> edges;

	public Graph build() {
		BasicGraph graph = new BasicGraph();
		for (UndirectedEdge edge : edges) {
			graph.add(edge);
		}
		return graph;
	}
}
