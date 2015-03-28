package generate;

import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class Gadget extends Graph {

    private Integer heartSize;
    private Integer armSize;

    public Gadget(Integer heartSize, Integer armSize) {
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
