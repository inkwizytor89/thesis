package generate;

import java.util.LinkedList;
import structure.graph.Edge;
import structure.graph.Graph;

public class PathGraph extends Graph {

    public PathGraph(Integer vertexCount) {
        super();
        createVertex(vertexCount);
        LinkedList<Edge> newEdges = new LinkedList<>();
        for (int i = 0; i < vertices.length - 1; i++) {
            newEdges.add(new Edge(vertices[i], vertices[i + 1]));

        }
        edges = newEdges.toArray(new Edge[newEdges.size()]);
    }
}
