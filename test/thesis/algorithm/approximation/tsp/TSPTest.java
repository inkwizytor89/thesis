package thesis.algorithm.approximation.tsp;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import thesis.algorithm.approximation.clique.CoverDualClique;
import thesis.algorithm.approximation.clique.NaiveClique;
import thesis.generate.GraphGenerator;
import thesis.generate.RandomGraphCompleteGenerator;
import thesis.generate.RandomGraphGenerator;
import thesis.structure.graph.Graph;

public class TSPTest {

	private static final String RANDOM_GRAPH_NAME = "RandomCompleteGraph";
	RandomGraphCompleteGenerator graphGenerator = new RandomGraphCompleteGenerator(11);

	@Test
	public void VertexCoverRandomGraph1() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph2() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph3() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph4() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph5() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph6() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph7() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	@Test
	public void VertexCoverRandomGraph8() throws Exception {
		isCorrect(createRandomCompleteGraph().labeledAs(RANDOM_GRAPH_NAME));
	}
	
	private void isCorrect(Graph graph) {
		System.out.println(graph.getLabel());
		Integer mentorRoadWeight = NaiveTSP.returnRoadWeight(graph.copedGraphEdges());
		System.out.println("\tTSP-MENTOR find road size " + mentorRoadWeight);
		Integer appRoadTSP = ApproxTSPTour.returnRoadWeight(graph.copedGraphEdges());
		System.out.println("\tTSP-APPROX Alghoritm find road size " + appRoadTSP);
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		assertTrue(mentorRoadWeight <= appRoadTSP);
	}	
	
	private Graph createRandomCompleteGraph() {
		return graphGenerator.buildGraph();
	}
}
