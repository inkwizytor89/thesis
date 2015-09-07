package thesis.generate.sample_graph;

import java.util.LinkedList;

import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;

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
