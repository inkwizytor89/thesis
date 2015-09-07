package thesis.algorithm.approximation.clique;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import thesis.algorithm.approximation.clique.CoverDualClique;
import thesis.algorithm.approximation.vertex_cover.DumpDegreeVertexCover;
import thesis.algorithm.approximation.vertex_cover.EdgesVertexCover;
import thesis.algorithm.approximation.vertex_cover.NaiveVertexCover;
import thesis.generate.RandomGraphGenerator;
import thesis.generate.sample_graph.Snowflake;
import thesis.structure.graph.Graph;

public class CliqueTest {

	RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(28);

	@Test
	public void VertexCoverRandomGraph1() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph2() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph3() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph4() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph5() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph6() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph7() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	@Test
	public void VertexCoverRandomGraph8() throws Exception {
		isCorrect(createRandomGraph().labeledAs("RandomGraph"));
	}
	
	private void isCorrect(Graph graph) {
		System.out.println(graph.getLabel());
		Integer mentorSize = NaiveClique.cliqueCount(graph.copedGraphEdges());
		System.out.println("\tCLIQUE-MENTOR find clique size " + mentorSize);
		Integer cliqueSize = CoverDualClique.cliqueCount(graph);
		System.out.println("\tCLIQUE-EDGES-APPROX Alghoritm find clique size " + cliqueSize);
		System.out.println();
		
		assertTrue(mentorSize >= cliqueSize);
	}	
	
	private Graph createRandomGraph() {
		randomGraphGenerator.randomize();
		return randomGraphGenerator.buildGraph();
	}
}
