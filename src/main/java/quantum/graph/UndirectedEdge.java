package quantum.graph;

import com.google.common.base.Preconditions;

import lombok.Getter;
import lombok.ToString;

/**
 * An undirected edge represents an edge between two vertices.
 */
@ToString
public class UndirectedEdge {

	@Getter
	private final int vertex1;

	@Getter
	private final int vertex2;

	public UndirectedEdge(int vertex1, int vertex2) {
		Preconditions.checkArgument(vertex1 != vertex2);
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}
}
