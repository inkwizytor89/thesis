package generate;

import structure.graph.Edge;
import structure.graph.Graph;

public class SimpleStarGraph extends Graph {

    public SimpleStarGraph(Integer armCount) {
        createVertex(armCount + 1);
        edges = new Edge[armCount];
        for (int i = 0; i < armCount; i++) {
            edges[i] = new Edge(vertices[0], vertices[i + 1]);
        }
    }
}
