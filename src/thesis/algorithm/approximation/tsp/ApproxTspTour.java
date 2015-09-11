package thesis.algorithm.approximation.tsp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

public class ApproxTspTour {

	public static List<Vertex> cache;

	/**
	 * Zwraca kopie wierzchołków
	 * 
	 * @param graph
	 * @return
	 */
	public static List<Vertex> returnRoad(Graph graph) {
		Graph tree = graph.getMinimumSpanningTree();
		cache = preOrderWalk(tree);

		return cache;
	}

	public static Integer returnRoadWeight(Graph graph) {
		List<Vertex> road = returnRoad(graph);
		return NaiveTSP.calculateRoadWeight(road);
	}

	private static List<Vertex> preOrderWalk(Graph tree) {
		List<Vertex> result = new ArrayList<Vertex>();
		LinkedList<Vertex> stack = new LinkedList<Vertex>();
		stack.addFirst(tree.getVertices()[0]);
		while (!stack.isEmpty()) {
			Vertex tmpVertex = stack.pollLast();
			result.add(tmpVertex);
			for (Edge edge : tmpVertex.getBindedEdges()) {
				Vertex anotherVertex = edge.getAnotherVertex(tmpVertex);
				if (!stack.contains(anotherVertex) && !result.contains(anotherVertex)) {
					stack.addLast(anotherVertex);
				}
			}
		}
		return result;
	}

}
