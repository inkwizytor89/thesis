package naive;

import structure.graph.Graph;
import structure.graph.Vertex;

public class CoverDualClique {

    public static Integer cliqueCount(Graph graph) {
        Integer result = DumpDegreeVertexCover.coverCount(graph.getComplement());
        return graph.getVerticesCount() - result;
    }
}
