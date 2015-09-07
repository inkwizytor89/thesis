package thesis.generate.sample_graph;

import java.util.LinkedList;
import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;

public class CompleteGraph extends Graph {
    
    public CompleteGraph(Integer vertexCount) {
        super();
        createVertex(vertexCount);
        LinkedList<Edge> newEdges = new LinkedList<>();
        for(int i=0; i<vertices.length-1; i++) {
            for(int j=i+1; j<vertices.length; j++) {
                newEdges.add(new Edge(vertices[i], vertices[j]));
            }
        }
        edges = newEdges.toArray(new Edge[newEdges.size()]);
    }
    
}
