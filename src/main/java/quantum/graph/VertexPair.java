package quantum.graph;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VertexPair implements Comparable<VertexPair> {

	private final Vertex vertex1;
	private final Vertex vertex2;

	/**
	 * Orders first by vertex1 id and then by vertex2 id.
	 */
	@Override
	public int compareTo(VertexPair other) {
		if (vertex1.getId() > other.vertex1.getId()) {
			return 1;
		}
		if (vertex1.getId() < other.vertex1.getId()) {
			return -1;
		}
		return vertex2.getId() - other.vertex2.getId();
	}

	/**
	 * @return the ids for this vertex pair
	 */
	public String getIds() {
		return vertex1.getId() + " " + vertex2.getId();
	}
}
