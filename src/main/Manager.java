package main;

import controller.InputReader;
import generate.CompleteGraph;
import generate.EmptyGraph;
import generate.Gadget;
import generate.PathGraph;
import naive.CoverDualClique;
import naive.DumpDegreeVertexCover;
import naive.EdgesVertexCover;
import naive.NaiveVertexCover;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;
import test.CliqueTest;
import test.GraphGenerator;
import test.LeaktGraphGenerator;
import test.RandomGraphGenerator;
import test.VertexCoverTest;
import view.OutputWritter;

public class Manager {

    /**
     * Pobranie wejścia do postaci grafu. Utworzenie MST z zadanego grafu oraz
     * wypisanie rozwiązania.
     *
     * @param input
     * @param output
     */
    Manager(String input, String output) {

        InputReader inputReader;
        OutputWritter outputWritter;
        if (input == null) {
            inputReader = new InputReader();
        } else {
            inputReader = new InputReader(input);
        }

        if (output == null) {
            outputWritter = new OutputWritter();
        } else {
            outputWritter = new OutputWritter(output);
        }
        Boolean withMentor = false;

//        VertexCoverTest vertexCoverTest = new VertexCoverTest();
//        vertexCoverTest.run(withMentor);

        CliqueTest cliqueTest = new CliqueTest();
        cliqueTest.run(withMentor);
        
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
