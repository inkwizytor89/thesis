package naive;

import java.util.LinkedList;
import structure.graph.Graph;
import structure.graph.Vertex;

public class DumpDegreeVertexCover {
    
    public static LinkedList<Vertex> cache;
    
    public static Integer coverCount(Graph graph) {
        
        LinkedList<Vertex> cover = new LinkedList<>();
        while (graph.getMarkedEdgeCount() > 0) {
//            System.err.println("liczba zaznaczonych krawedzi "+graph.getMarkedEdgeCount());
//            System.err.println(graph.toString());
            Vertex minDegreeVertex = graph.getMinDegreeVertexNotInsulated();
            Vertex localGreedVertex = graph.getLocalGreedVertex(minDegreeVertex);
            //System.err.println("min "+minDegreeVertex.toString()+"greed "+localGreedVertex.toString());
            cover.add(localGreedVertex);
            graph.unmarkConnectedEdges(localGreedVertex);
        }
        graph.markAllEdges();
//        if (graph.getVerticesCount() == 6 &&  cover.size() == 4) {
//        for(Vertex v : cover)
//        System.out.print(v.toString()+" "); System.out.println("");}
        cache = cover;
        return cover.size();
    }
    
    public static String show() {
        String result = "[ ";
        for (Vertex v : cache) {
            result+=v.index+" ";
        }
        return result+"]";
    }
    
}
