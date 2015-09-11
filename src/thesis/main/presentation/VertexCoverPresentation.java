package thesis.main.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import thesis.algorithm.approximation.vertex_cover.DumpDegreeVertexCover;
import thesis.algorithm.approximation.vertex_cover.EdgesVertexCover;
import thesis.generate.RandomGraphGenerator;
import thesis.generate.sample_graph.Snowflake;
import thesis.structure.graph.Graph;

public class VertexCoverPresentation {

	final private static Integer RANDOM_TEST_COUNT = 10;

	public static void presents() {
		System.out.println("\n VERTEX COVER MODE:");
		System.out.println("\nProgram will find cover for 3 Snowflake and "
				+ RANDOM_TEST_COUNT + " randoms graphs:\n");
		List<Graph> testGraphs = new ArrayList<>();

		testGraphs.add(new Snowflake(128, 16).labeledAs("Snowflake[128, 16]"));
		testGraphs.add(new Snowflake(32, 256).labeledAs("Snowflake[32, 256]"));
		testGraphs.add(new Snowflake(64, 64).labeledAs("Snowflake[64, 64]"));

		RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(1024);
		for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
			testGraphs.add(randomGraphGenerator.buildGraph().labeledAs("RandomGraph"));
//			randomGraphGenerator.randomize();
		}

		for (Graph graph : testGraphs) {
			System.out.println(graph.getLabel());
			Integer degree = DumpDegreeVertexCover.coverCount(graph
					.copedGraphEdges());
			System.out
					.println("\tVERTEX-COVER-DEGREES-APPROX Alghoritm find cover size "
							+ degree);
			Integer edge = EdgesVertexCover.coverCount(graph.copedGraphEdges());
			System.out
					.println("\tVERTEX-COVER-EDGES-APPROX Alghoritm find cover size "
							+ edge);
			System.out.println();
		}
	}
}
