package thesis.structure.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa opisująca wierzchołek.
 * @author kamil
 */
public class Vertex {

    /**
     * Identyfikator wierzchołka.
     */
    public Integer index;
    
    private List<Edge> bindEdges = new ArrayList<Edge>();

    public Vertex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return index.toString();
    }

    public Integer toInteger() {
        return index;
    }

	public void bind(Edge edge) {
		bindEdges.add(edge);
	}
	
	public List<Edge> getBindedEdges() {
		return bindEdges;
	}

	public Integer getWeightTo(Vertex vertex) {
		for (Edge edge : bindEdges) {
			Vertex neighbor = edge.getAnotherVertex(this);
			if (neighbor.equals(vertex)) {
				return edge.weight;
			}
		}
		return null;
	}
}
