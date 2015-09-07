package thesis.generate.sample_graph;

import thesis.structure.graph.Edge;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;


public class Snowflake extends Graph {

    private Integer heartSize;
    private Integer armSize;

    public Snowflake(Integer heartSize, Integer armSize) {
        this.heartSize = heartSize;
        this.armSize = armSize;
        Graph heart = new CompleteGraph(heartSize);
        Graph arm = new SimpleStarGraph(heartSize);
        Edge[] bridge = new Edge[heartSize * heartSize];
        Integer bridgeIndex = 0;
        for (int i = 0; i < heartSize; i++) {
            for (int j = 0; j < heartSize; j++) {
                bridge[bridgeIndex++] = new Edge(new Vertex(i), new Vertex(j + 1));
            }
        }
        createStarGraph(heart, arm, bridge, armSize);
    }

    public Integer getHeartSize() {
        return heartSize;
    }

    public Integer getArmSize() {
        return armSize;
    }
}
