package thesis.structure.graph;

import java.util.Arrays;
import java.util.LinkedList;

import thesis.structure.grapf.exception.SeparableGraphException;
import thesis.structure.set.Node;

/**
 * Klasa opisujaca graf
 *
 * @author kamil
 */
public class Graph {

	protected Vertex[] vertices;
	protected Edge[] edges;
	protected Integer[] degrees;
	protected String label;

	public Graph() {
	}

	public Graph(Graph graph) {
		createVertex(graph.getVerticesCount());
		edges = new Edge[graph.getEdgesCount()];
		for (int i = 0; i < graph.getEdgesCount(); i++) {
			Integer startIndex = graph.getEdges()[i].vertexStart.index;
			Integer endIndex = graph.getEdges()[i].vertexEnd.index;
			edges[i] = new Edge(vertices[startIndex], vertices[endIndex]);
		}
	}

	public Graph(Vertex[] vertices, Edge[] edges) {
		this.vertices = vertices;
		this.edges = edges;
	}

	/**
	 * Create copy of graphs with specific edges
	 *
	 * @param a
	 *            first graph
	 * @param b
	 *            second graph
	 * @param bridges
	 *            array of edges betwen graph a and graph b
	 */
	public Graph(Graph a, Graph b, Edge[] bridges) {
		createStarGraph(a, b, bridges, 1);
	}

	protected void createStarGraph(Graph a, Graph b, Edge[] bridges, Integer copyCount) {

		createVertex(a.getVerticesCount() + b.getVerticesCount() * copyCount);
		edges = new Edge[a.getEdgesCount() + (b.getEdgesCount() + bridges.length) * copyCount];
		Integer edgesIndex = 0;
		for (int i = 0; i < a.edges.length; i++) {
			Edge e = a.edges[i];
			edges[edgesIndex++] = new Edge(vertices[e.getVertexStart().toInteger()], vertices[e
					.getVertexEnd().toInteger()]);
		}

		Integer aGraphShift = a.getVerticesCount();
		Integer bGraphShift = b.getVerticesCount();
		for (int c = 0; c < copyCount; c++) {
			for (int i = 0; i < b.edges.length; i++) {
				Edge e = b.edges[i];
				edges[edgesIndex++] = new Edge(vertices[e.getVertexStart().toInteger()
						+ aGraphShift + bGraphShift * c], vertices[e.getVertexEnd().toInteger()
						+ aGraphShift + bGraphShift * c]);
			}
			for (int i = 0; i < bridges.length; i++) {
				Edge e = bridges[i];
				edges[edgesIndex++] = new Edge(vertices[e.getVertexStart().toInteger()], vertices[e
						.getVertexEnd().toInteger() + aGraphShift + bGraphShift * c]);
			}
		}
	}

	protected void createVertex(Integer vertexCount) {
		vertices = new Vertex[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			vertices[i] = new Vertex(i);
		}
	}

	public Integer getEdgesCount() {
		return edges.length;
	}

	public Edge[] getEdges() {
		return edges;
	}

	public Integer getMarkedEdgeCount() {
		Integer count = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i].isMarked) {
				count++;
			}
		}
		return count;
	}

	public Integer getVerticesCount() {
		return vertices.length;
	}

	public Vertex[] getVertices() {
		return vertices;
	}

	/**
	 * Zwraca podgraf grafu głównego będący minimalnym drzewem wg algorytmu
	 * Kraskala.
	 *
	 * @return
	 */
	public Graph getMinimumSpanningTree() {
		Node[] nodeVertices = new Node[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			nodeVertices[i] = new Node();
		}
		Arrays.sort(edges, new EdgeWeightComparator());
		LinkedList<Edge> mst = new LinkedList<>();
		for (Edge edge : edges) {
			Node start = nodeVertices[edge.getVertexStart().index].find();
			Node end = nodeVertices[edge.getVertexEnd().index].find();
			if (!start.equals(end)) {
				mst.add(edge);
				start.union(end);
			}
		}
		if (mst.size() != vertices.length - 1) {
			throw new SeparableGraphException();
		}
		return new Graph(vertices, mst.toArray(new Edge[mst.size()]));
	}

	/**
	 * Wowołuje na grafie leksykograficzny porządek.
	 */
	public void prepareToShow() {
		Arrays.sort(edges, new EdgeShowComparator());
	}

	public void unmarkConnectedEdges(Vertex vertex) {
		degrees = null;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i].contains(vertex)) {
				edges[i].setIsMarked(false);
			}
		}
	}

	public Integer degree(Vertex vertex) {
		Integer count = 0;
		for (Edge edge : edges) {
			if (edge.contains(vertex)) {
				count++;
			}
		}
		return count;
	}

	public void reloadDegree() {
		if (degrees == null) {
			degrees = new Integer[vertices.length];
			for (int i = 0; i < degrees.length; i++) {
				degrees[i] = 0;
			}
			for (int i = 0; i < edges.length; i++) {
				if (edges[i].isMarked()) {
					degrees[edges[i].getVertexStart().toInteger()]++;
					degrees[edges[i].getVertexEnd().toInteger()]++;
				}
			}
		}
	}

	public Vertex getMinDegreeVertexNotInsulated() {
		reloadDegree();
		Integer index = null;
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] > 0) {
				index = i;
				break;
			}
		}
		if (index == null) {
			System.err.println(toString());
			return null;
			// throw new RuntimeException("Not uninsulates vertex in grapf");
		}
		for (int i = 0; i < degrees.length; i++) {
			if (degrees[i] < degrees[index] && degrees[i] > 0) {
				index = i;
			}
		}
		return vertices[index];
	}

	/**
	 * Zwraca wierzchołek o największym stopniu incydentny dla zadanego
	 * wierzchołka
	 *
	 * @param vertex
	 *            zadany wierzchołek
	 * @return lokalny wierzchołek o największym stopniu
	 */
	public Vertex getLocalGreedVertex(Vertex vertex) {
		Vertex localMaxDegreeVertex = vertex;
		Integer localMaxDegreeDegree = 0;
		for (Edge edge : edges) {
			if (edge.contains(vertex) && edge.isMarked) {
				Vertex tempV = edge.getAnotherVertex(vertex);
				Integer tempD = degree(tempV);
				if (tempD > localMaxDegreeDegree) {
					localMaxDegreeVertex = tempV;
					localMaxDegreeDegree = tempD;
				}
			}
		}
		return localMaxDegreeVertex;
	}

	/**
	 * Generuje kopie grafu ze względu na tablice krawędzi
	 *
	 * @return kopia grafu
	 */
	public Graph copedGraphEdges() {
		Vertex[] vertices = this.vertices;
		LinkedList<Edge> copyEdges = new LinkedList<>();
		for (Edge edge : edges) {
			copyEdges.add(edge);
		}
		return new Graph(vertices, copyEdges.toArray(new Edge[copyEdges.size()]));
	}

	/**
	 * Generate copy of vervicles and that edges where aren't in orginal
	 *
	 * @return new complement graph
	 */
	public Graph getComplement() {
		Graph complementGraph = new Graph(this);
		return complementGraph.setAsComplemented();
	}

	/**
	 * Delete orginal edges and create complementar edges
	 *
	 * @return the same graph with complementar edges
	 */
	private Graph setAsComplemented() {
		boolean[][] edgesTable = new boolean[getVerticesCount()][getVerticesCount()];
		for (int i = 0; i < getVerticesCount(); i++) {
			for (int j = i + 1; j < getVerticesCount(); j++) {
				edgesTable[i][j] = false;
			}
		}
		for (int i = 0; i < getEdgesCount(); i++) {
			int start = edges[i].getVertexStart().toInteger();
			int end = edges[i].getVertexEnd().toInteger();
			if (start < end) {
				edgesTable[start][end] = true;
			} else {
				edgesTable[end][start] = true;
			}
		}
		LinkedList<Edge> newEdges = new LinkedList<>();
		for (int i = 0; i < getVerticesCount(); i++) {
			for (int j = i + 1; j < getVerticesCount(); j++) {
				if (!edgesTable[i][j]) {
					newEdges.add(new Edge(vertices[i], vertices[j]));
				}
			}
		}
		edges = newEdges.toArray(new Edge[newEdges.size()]);
		return this;
	}

	@Override
	public String toString() {
		String result = "Graph: " + vertices.length + " " + edges.length + "\n";
		for (Edge edge : edges) {
			result += edge.toString();
		}
		return result;
	}

	public String getLabel() {
		return label + "(" + vertices.length + "," + edges.length + ")";
	}

	public Edge getFirstMarkedEdge() {
		for (int i = 0; i < edges.length; i++) {
			if (edges[i].isMarked) {
				return edges[i];
			}
		}
		return null;
	}

	public void markAllEdges() {
		for (int i = 0; i < edges.length; i++) {
			edges[i].isMarked = true;
		}
	}

	public Graph labeledAs(String label) {
		this.label = label;
		return this;
	}
}
