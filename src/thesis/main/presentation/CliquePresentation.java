package thesis.main.presentation;

import java.util.ArrayList;
import java.util.List;

import thesis.algorithm.approximation.clique.CoverDualClique;
import thesis.generate.RandomGraphGenerator;
import thesis.structure.graph.Graph;

public class CliquePresentation {
	
	private static final Integer RANDOM_TEST_COUNT = 10;

	public static void presents() {
		System.out.println("\nCLIQUE MODE:");
		System.out.println("\nProgram will find clique for " + RANDOM_TEST_COUNT
				+ " randoms graphs:\n");
		List<Graph> testGraphs = new ArrayList<>();

		RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(1024);
		for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
			testGraphs.add(randomGraphGenerator.buildGraph().labeledAs("RandomGraph"));
//			randomGraphGenerator.randomize();
		}

		for (Graph graph : testGraphs) {
			System.out.println(graph.getLabel());
			Integer cliqueCount = CoverDualClique.cliqueCount(graph);
			System.out.println("\tCLIQUE-EDGES-APPROX Alghoritm find clique size " + cliqueCount);
			System.out.println();
		}
	}

}
