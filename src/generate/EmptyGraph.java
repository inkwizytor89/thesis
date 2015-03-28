package generate;

import java.util.LinkedList;
import structure.graph.Edge;
import structure.graph.Graph;

public class EmptyGraph extends Graph {
    
    public EmptyGraph(Integer vertexCount) {
        super();
        createVertex(vertexCount);
        LinkedList<Edge> newEdges = new LinkedList<>();
        edges = newEdges.toArray(new Edge[newEdges.size()]);
    }
    
}
