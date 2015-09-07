package thesis.algorithm.approximation.clique;

import thesis.algorithm.approximation.vertex_cover.DumpDegreeVertexCover;
import thesis.structure.graph.Graph;
import thesis.structure.graph.Vertex;

public class CoverDualClique {

    public static Integer cliqueCount(Graph graph) {
        Integer result = DumpDegreeVertexCover.coverCount(graph.getComplement());
        return graph.getVerticesCount() - result;
    }
}
