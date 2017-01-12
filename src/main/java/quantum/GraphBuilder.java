package quantum;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GraphBuilder {

	private final List<UndirectedEdge> edges;

	public Graph build() {
		Graph graph = new Graph();
		for (UndirectedEdge edge : edges) {
			graph.add(edge);
		}
		return graph;
	}
}
