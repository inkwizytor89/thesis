package thesis.main;

import thesis.algorithm.approximation.clique.CliqueTest;
import thesis.algorithm.approximation.clique.CoverDualClique;
import thesis.algorithm.approximation.vertex_cover.DumpDegreeVertexCover;
import thesis.algorithm.approximation.vertex_cover.EdgesVertexCover;
import thesis.algorithm.approximation.vertex_cover.NaiveVertexCover;
import thesis.algorithm.approximation.vertex_cover.VertexCoverTest;
import thesis.generate.GraphGenerator;
import thesis.generate.RandomGraphGenerator;
import thesis.generate.sample_graph.CompleteGraph;
import thesis.generate.sample_graph.EmptyGraph;
import thesis.generate.sample_graph.Snowflake;
import thesis.generate.sample_graph.PathGraph;
import thesis.main.presentation.CliquePresentation;
import thesis.main.presentation.SubsetSumPresentation;
import thesis.main.presentation.TSPPresentation;
import thesis.main.presentation.VertexCoverPresentation;
import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

public class Manager {

    /**
     * Pobranie wejścia do postaci grafu. Utworzenie MST z zadanego grafu oraz
     * wypisanie rozwiązania.
     *
     * @param input
     * @param output
     */
    Manager() {
    	
    	VertexCoverPresentation.presents();
    	CliquePresentation.presents();
    	TSPPresentation.presents();
    	SubsetSumPresentation.presents();
    	

//        Boolean withMentor = false;

//        VertexCoverTest vertexCoverTest = new VertexCoverTest();
//        vertexCoverTest.run(withMentor);

//        CliqueTest cliqueTest = new CliqueTest();
//        cliqueTest.run(withMentor);
        
//        Graph g = new PathGraph(5);
//        System.out.println(g);
//        System.out.println("Clique: "+CoverDualClique.coverCount(g));
//        Graph complementy = new  Graph(g).getComplement();
//        System.out.println("complementy:");
//        System.out.println(complementy);
//        System.out.println("Clique: "+CoverDualClique.coverCount(complementy));
//        Graph empty = new EmptyGraph(12);
//        System.out.println("empty:");
//        System.out.println(empty);
//        System.out.println("Clique: "+CoverDualClique.coverCount(empty));
//        Graph complete = new CompleteGraph(12);
//        System.out.println("complete:");
//        System.out.println(complete);
//        System.out.println("Clique: "+CoverDualClique.coverCount(complete));
    }
}
