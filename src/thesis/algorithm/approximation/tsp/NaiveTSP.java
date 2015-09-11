package thesis.algorithm.approximation.tsp;

import java.util.ArrayList;
import java.util.List;

import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import thesis.structure.bitvector.BitVector;
import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

public class NaiveTSP {

	public static Integer returnRoadWeight(Graph graph) {
		List<Vertex> road = returnRoad(graph);
		return calculateRoadWeight(road);
	}

	public static List<Vertex> returnRoad(Graph graph) {
		Integer bestRoadWeight = Integer.MAX_VALUE;
		ICombinatoricsVector<Vertex> bestPermutation = null;

		for (ICombinatoricsVector<Vertex> permutation : returnAllPermutation(graph.getVertices())) {
			Integer roadWeight = getRoadWeight(permutation.getVector());
			if (roadWeight < bestRoadWeight) {
				bestPermutation = permutation;
				bestRoadWeight = roadWeight;
			}
		}
		return bestPermutation.getVector();
	}

	private static Generator<Vertex> returnAllPermutation(Vertex[] vertices) {
		ICombinatoricsVector<Vertex> originalVector = Factory.createVector(vertices);
		Generator<Vertex> generator = Factory.createPermutationGenerator(originalVector);
		return generator;
	}

	private static Integer getRoadWeight(List<Vertex> road) {
		Integer roadWeight = 0;
		int size = road.size();
		for (int i = 0; i < size; i++) {
			Vertex startVertex = road.get(i);
			Vertex endVertex = road.get((i+1) % size);
			roadWeight += startVertex.getWeightTo(endVertex);
		}
		return roadWeight;
	}

	public static Integer calculateRoadWeight(List<Vertex> road) {
		return getRoadWeight(road); 
				
	}

	// public static List<Vertex> returnRoad(Graph graph) {
	// BitVector bitVector = new BitVector(graph.getEdgesCount());
	//
	// do {
	// List<Edge> edges = new ArrayList<Edge>();
	// for (int i = 0; i < graph.getEdges().length; i++) {
	// if(bitVector.getPositionValue(i)) {
	// edges.add(graph.getEdges()[i]);
	// }
	// }
	// if(areCycles(edges, graph) && isConnectivity(edges) ) {
	// Integer weight = getWeightSum(edges);
	// }
	//
	// } while (bitVector.next());
	//
	//
	// return null;
	// }
	//
	// private static boolean areCycles(List<Edge> edges, Graph graph) {
	// Integer[] vertexCount = new Integer[graph.getVerticesCount()];
	// for (int i = 0; i < vertexCount.length; i++) {
	// vertexCount[i] = 0;
	// }
	// for (Edge edge : edges) {
	// vertexCount[edge.getVertexStart().index]++;
	// vertexCount[edge.getVertexEnd().index]++;
	// }
	// for (int i = 0; i < vertexCount.length; i++) {
	// if (vertexCount[i] != 2) {
	// return false;
	// }
	// }
	// return true;
	//
	// }
	//
	// private static boolean isConnectivity(List<Edge> edges) {
	// // TODO Auto-generated method stub
	// return false;
	// }
	//
	// private static Integer getWeightSum(List<Edge> edges) {
	// Integer sum = 0;
	// for (Edge edge : edges) {
	// sum+= edge.getWeight();
	// }
	// return sum;
	// }

}
