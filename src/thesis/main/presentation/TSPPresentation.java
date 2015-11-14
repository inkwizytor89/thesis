package thesis.main.presentation;

import java.util.ArrayList;
import java.util.List;

import thesis.algorithm.approximation.tsp.ApproxTSPTour;
import thesis.generate.RandomGraphCompleteGenerator;
import thesis.structure.graph.Graph;

public class TSPPresentation {

	private static final Integer RANDOM_TEST_COUNT = 10;

	public static void presents() {
		System.out.println("\nTSP MODE:");
		System.out.println("\nProgram will find road for " + RANDOM_TEST_COUNT
				+ " randoms graphs:\n");
		List<Graph> testGraphs = new ArrayList<>();

		RandomGraphCompleteGenerator graphGenerator = new RandomGraphCompleteGenerator(1024);
		for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
			testGraphs.add(graphGenerator.buildGraph().labeledAs("RandomCompleteGraph"));
		}

		for (Graph graph : testGraphs) {
			System.out.println(graph.getLabel());
			Integer degree = ApproxTSPTour.returnRoadWeight(graph.copedGraphEdges());
			System.out.println("\tApprox TSP Tour Alghoritm find cover size " + degree);
			System.out.println();
		}
	}

}
