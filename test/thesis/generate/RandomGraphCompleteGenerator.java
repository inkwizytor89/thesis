package thesis.generate;

import java.util.Random;

import thesis.generate.sample_graph.CompleteGraph;
import thesis.structure.graph.Graph;

public class RandomGraphCompleteGenerator {

	private Integer size;
	private Random random = new Random();

	public RandomGraphCompleteGenerator(Integer size) {
		this.size = size;
	}

	public Graph buildGraph() {
		beforeBuidGraph();
		Graph graph = new CompleteGraph(size);
		/*
		 * Wprowadzamy zależność odległośi trójkąta. Każda waga skłąda się z
		 * weightBase które wynosi tyle liczba wierzchołków oraz wrtości losowej
		 * mniejszej niż baseWeight. Sprawia to że nie jest możliwe aby przez
		 * wierzchołek pośredni było szybciej niż bezpośrednio po krawędzi.
		 */
		Integer weightBase = graph.getVerticesCount();
		for (int i = 0; i < graph.getEdges().length; i++) {
			graph.getEdges()[i].setWeight(weightBase+ random.nextInt(weightBase));
		}
		return graph;
	}

	private void beforeBuidGraph() {
		
	}
}
