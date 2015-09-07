package thesis.algorithm.approximation.vertex_cover;

import java.util.LinkedList;
import java.util.List;

import thesis.structure.bitvector.BitVector;
import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;
/**
 * Algorithm checking all possibilities
 * @author inkwizytor89
 */
public class NaiveVertexCover {
    
    public static LinkedList<Vertex> cache;

    public static Boolean isCovered(Graph graph, List<Vertex> cover) {
        for (Edge edge : graph.getEdges()) {
            if (!cover.contains(edge.getVertexStart()) && !cover.contains(edge.getVertexEnd())) {
                return false;
            }
        }
        return true;
    }
    
    public static Integer coverCount(Graph graph) {
        Integer vertexCount = graph.getVerticesCount();
        Integer coverResult = vertexCount;
        BitVector bitVector = new BitVector(vertexCount);
        LinkedList<Vertex> cover = new LinkedList<>();
        do {
            LinkedList<Vertex> tempCover = new LinkedList<>();
            for (int i=0;i<vertexCount;i++) {
                if (bitVector.getPositionValue(i)) {
                    tempCover.add(graph.getVertices()[i]);
                }
            }
            if (isCovered(graph, tempCover) && tempCover.size() < coverResult) {
                cover = tempCover;
                coverResult = tempCover.size();
            }
        }while (bitVector.next());
        cache = cover;
        return coverResult;
    }
    
    public static String show() {
        String result = "[ ";
        for (Vertex v : cache) {
            result+=v.index+" ";
        }
        return result+"]";
    }
}
