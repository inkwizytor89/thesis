package test;

import generate.Gadget;
import java.util.HashMap;
import naive.DumpDegreeVertexCover;
import naive.EdgesVertexCover;
import naive.NaiveVertexCover;
import structure.graph.Graph;

public class VertexCoverTest {

    final private Integer RANDOM_TEST_COUNT = 10;

    public VertexCoverTest() {
    }

    public void run(Boolean withMentor) {
        RandomGraphGenerator randomGraphGenerator;
        System.out.println("VERTEX COVER MODE:");
        System.out.println("Program will find cover for 3 Snowflake and "+RANDOM_TEST_COUNT+" randoms graphs:");
        HashMap<String, Graph> test = new HashMap<>();
        if (withMentor) {
            System.err.println("Mentor alert");
            test.put("Snowflake[6,2]", new Gadget(6, 2));
            test.put("Snowflake[3,6]", new Gadget(3, 6));
            test.put("Snowflake[4,5]", new Gadget(4, 5));
            randomGraphGenerator = new RandomGraphGenerator(28);
        } else {
            test.put("Snowflake0", new Gadget(128, 16));
            test.put("Snowflake1", new Gadget(32, 256));
            test.put("Snowflake2", new Gadget(64, 64));
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
            if (withMentor) {
                Integer mentor = NaiveVertexCover.coverCount(graph.copedGraphEdges());
                System.out.println("\tVERTEX-COVER-MENTOR find cover size" + mentor);
            }
            Integer degree = DumpDegreeVertexCover.coverCount(graph.copedGraphEdges());
            System.out.println("\tVERTEX-COVER-DEGREES-APPROX Alghoritm find cover size" + degree);
            Integer edge = EdgesVertexCover.coverCount(graph.copedGraphEdges());
            System.out.println("\tVERTEX-COVER-EDGES-APPROX Alghoritm find cover size" + edge);
            System.out.println();
        }
    }
}
