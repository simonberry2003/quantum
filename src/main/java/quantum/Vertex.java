package quantum;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.val;

/**
 * A vertex represents a vertex in a graph and any connections to other vertices.
 */
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
public class Vertex {

	@Getter
	private final int id;

	/**
	 * Set of connections to other vertices
	 */
	private final Set<Integer> connections = new HashSet<>();

	/**
	 * Links the specified vertex to this vertex in both directions.
	 * @param vertex
	 */
	public void link(Vertex vertex) {
		connections.add(vertex.getId());
		vertex.connections.add(id);
	}

	/**
	 * @param vertex
	 * @return true if the specified vertex is connected to this vertex
	 */
	public boolean isConnectedTo(Vertex vertex) {
		return connections.contains(vertex.getId());
	}

	@Override
	public String toString() {
		val sb = new StringBuilder();
		sb.append(id + "[");
		for (val connection : connections) {
			sb.append(connection);
			sb.append(",");
		}
		sb.replace(sb.length() -1, sb.length(), "]");
		return sb.toString();
	}
}
