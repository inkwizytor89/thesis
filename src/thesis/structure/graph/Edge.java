package thesis.structure.graph;

import java.rmi.NoSuchObjectException;

/**
 * Klasa przedstawiająca krawędz nie skierowaną.
 *
 * @author kamil
 */
public class Edge {

	Vertex vertexStart;
	Vertex vertexEnd;
	Integer weight;
	protected Boolean isMarked = true;

	public Edge(Vertex vertexStart, Vertex vertexEnd) {
		this(vertexStart, vertexEnd, 1);
	}

	public Edge(Edge edge) {
		this(edge.vertexStart, edge.vertexEnd, edge.weight);
	}
	
	public Edge(Vertex vertexStart, Vertex vertexEnd, Integer weight) {
		this.vertexStart = vertexStart;
		this.vertexEnd = vertexEnd;
		this.weight = weight;
		this.vertexStart.bind(this);
		this.vertexEnd.bind(this);
	}

	public void setIsMarked(Boolean value) {
		isMarked = value;
	}

	public Vertex getVertexStart() {
		return vertexStart;
	}

	public Vertex getVertexEnd() {
		return vertexEnd;
	}

	public Integer getWeight() {
		return weight;
	}

	public Boolean contains(Vertex vertex) {
		return vertex.equals(vertexStart) || vertex.equals(vertexEnd);
	}

	@Override
	public String toString() {
		String result = "Edge: " + vertexStart.toString() + " " + vertexEnd.toString() + " ";
		result += weight;
		result += " [isMarked:" + isMarked + "]\n";
		return result;
	}

	public Boolean isMarked() {
		return isMarked;
	}

	public Vertex getAnotherVertex(Vertex vertex) {
		if (vertex.equals(vertexStart)) {
			return vertexEnd;
		}
		if (vertex.equals(vertexEnd)) {
			return vertexStart;
		}
		return null;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
}
