package thesis.algorithm.approximation.vertex_cover;

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

public class VertexCoverTest {

	RandomGraphGenerator randomGraphGenerator = new RandomGraphGenerator(28);

	@Test
	public void VertexCoverSnowfal_6_2() throws Exception {
		isCorrect(new Snowflake(6, 2).labeledAs("Snowflake[6,2]"));
	}

	@Test
	public void VertexCoverSnowfal_3_6() throws Exception {
		isCorrect(new Snowflake(3, 6).labeledAs("Snowflake[3,6]"));
	}

	@Test
	public void VertexCoverSnowfal_4_5() throws Exception {
		isCorrect(new Snowflake(4, 5).labeledAs("Snowflake[4,5]"));
	}

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
		Integer mentorCount = NaiveVertexCover.coverCount(graph.copedGraphEdges());
		System.out.println("\tVERTEX-COVER-MENTOR find cover size " + mentorCount);
		Integer degreeCount = DumpDegreeVertexCover.coverCount(graph.copedGraphEdges());
		System.out.println("\tVERTEX-COVER-DEGREES-APPROX Alghoritm find cover size " + degreeCount);
		Integer edgeCount = EdgesVertexCover.coverCount(graph.copedGraphEdges());
		System.out.println("\tVERTEX-COVER-EDGES-APPROX Alghoritm find cover size " + edgeCount);
		System.out.println();
		
		assertTrue(mentorCount <= degreeCount);
		assertTrue(mentorCount <= edgeCount);
	}
	
	private Graph createRandomGraph() {
//		randomGraphGenerator.randomize();
		return randomGraphGenerator.buildGraph();
	}
}
