package thesis.algorithm.approximation.clique;

import java.util.ArrayList;
import java.util.List;

import thesis.structure.bitvector.BitVector;
import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

public class NaiveClique {
	
	public static List<Vertex> cache;

	public static Integer cliqueCount(Graph graph) {
		Integer vertexCount = graph.getVerticesCount();
        Integer cliqueMaxSize = 0;
        BitVector bitVector = new BitVector(vertexCount);
        
        List<Vertex> clique = new ArrayList<>();
        do {
            List<Vertex> tempClique = new ArrayList<>();
            for (int i=0;i<vertexCount;i++) {
                if (bitVector.getPositionValue(i)) {
                    tempClique.add(graph.getVertices()[i]);
                }
            }
            if (tempClique.size() > cliqueMaxSize && isClique(graph, tempClique)) {
                clique = tempClique;
                cliqueMaxSize = tempClique.size();
            }
        }while (bitVector.next());
        cache = clique;
        return cliqueMaxSize;
	}

	private static boolean isClique(Graph graph, List<Vertex> clique) {
		for (Vertex startVertex : clique) {
			for (Vertex endVertex : clique) {
				if(!startVertex.equals(endVertex)) {
					boolean isConnected = false;
					for (Edge edge : graph.getEdges()) {
						if ( edge.contains(startVertex) && edge.contains(endVertex)) {
							isConnected = true;
							break;
						}
					}
					if (!isConnected) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
