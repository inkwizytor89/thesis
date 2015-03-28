package naive;

import java.util.LinkedList;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class EdgesVertexCover {
    public static Integer coverCount(Graph graph) {
        LinkedList<Vertex> cover = new LinkedList<>();
        while (graph.getMarkedEdgeCount() > 0) {
            Edge edge = graph.getFirstMarkedEdge();
            if (edge == null) {
                throw new RuntimeException ("No find marked edges, but function getMarkedEdgeCount > 0 ");
            }
            Vertex start = edge.getVertexStart();
            Vertex end = edge.getVertexEnd();
            //System.err.println(graph.toString());
            cover.add(start);
            cover.add(end);
            graph.unmarkConnectedEdges(start);
            graph.unmarkConnectedEdges(end);
        }
        graph.markAllEdges();
        return cover.size();
    }
}
