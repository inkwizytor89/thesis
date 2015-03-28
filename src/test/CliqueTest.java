package test;

import generate.Gadget;
import java.util.HashMap;
import naive.CoverDualClique;
import naive.DumpDegreeVertexCover;
import naive.EdgesVertexCover;
import naive.NaiveVertexCover;
import structure.graph.Graph;

public class CliqueTest {

    final private Integer RANDOM_TEST_COUNT = 10;

    public CliqueTest() {
    }

    public void run(Boolean withMentor) {
        RandomGraphGenerator randomGraphGenerator;
        System.out.println("CLIQUE MODE:");
        System.out.println("Program will find clique for "+RANDOM_TEST_COUNT+" randoms graphs:");
        HashMap<String, Graph> test = new HashMap<>();
        if (withMentor) {
            System.err.println("Mentor alert");
            System.err.println("No mentor alghoritm");
            randomGraphGenerator = new RandomGraphGenerator(28);
        } else {
            randomGraphGenerator = new RandomGraphGenerator(1024);
        }
        for (int i = 0; i < RANDOM_TEST_COUNT; i++) {
            //System.err.println("randomer " + i);
            test.put("Random"+i, randomGraphGenerator.buildGraph());
            randomGraphGenerator.randomize();
        }

        for (String key : test.keySet()) {
            Graph graph = test.get(key);
            System.out.println(key + "(" + graph.getVertices().length + "," + graph.getEdges().length + ")");
            if (withMentor && false) {
                Integer mentor = NaiveVertexCover.coverCount(graph.copedGraphEdges());
                System.out.println("\tBest solution find cover size" + mentor);
            }
            Integer cliqueCount = CoverDualClique.cliqueCount(graph);
            System.out.println("\tCLIQUE-EDGES-APPROX Alghoritm find clique size " + cliqueCount);
            System.out.println();
        }
    }
}
