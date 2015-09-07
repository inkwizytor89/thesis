package thesis.generate.sample_graph;

import java.util.LinkedList;

import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;

public class EmptyGraph extends Graph {
    
    public EmptyGraph(Integer vertexCount) {
        super();
        createVertex(vertexCount);
        LinkedList<Edge> newEdges = new LinkedList<>();
        edges = newEdges.toArray(new Edge[newEdges.size()]);
    }
    
}
