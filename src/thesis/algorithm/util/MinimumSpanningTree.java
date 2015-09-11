package thesis.algorithm.util;

import java.util.ArrayList;
import java.util.List;

import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

@Deprecated
public class MinimumSpanningTree {
	
	public static void run(Graph graph, Vertex root) {
		List <Vertex> treeVertex = new ArrayList<Vertex>();
		treeVertex.add(root);
		while(true) {
			Vertex newVertex = findNearestVertex(treeVertex);
		}
	}

	private static Vertex findNearestVertex(List<Vertex> tree) {
		Vertex nearestVertex = null;
		Integer bestWeight = Integer.MAX_VALUE;
		for (Vertex vertex : tree) {
			for (Edge edge : vertex.getBindedEdges()) {
				if (edge.getWeight() < bestWeight) {
					nearestVertex = edge.getAnotherVertex(vertex);
					bestWeight = edge.getWeight();
				}
			}
		}
		return nearestVertex;
	}
}
