package structure.graph;

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
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
    }

    public Edge(Vertex vertexStart, Vertex vertexEnd, Integer weight) {
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
        this.weight = weight;
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
        String result = "Edge: " + vertexStart.toString() + " " + vertexEnd.toString();
        if (weight != null) {
            result+= weight;
        }
        result += " [isMarked:"+isMarked+"]\n";
        return result;
    }

    Vertex getAnotherVertex(Vertex vertex) {
        if (vertex.equals(vertexStart)) {
            return vertexEnd;
        }
        return vertexStart;
    }

    public Boolean isMarked() {
        return isMarked;
    }
}
