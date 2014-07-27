package graph;

public class GraphImplementation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getGraph());
	}

	public static Graph getGraph() {
		Graph graph = new Graph();
		// All vertex
		Vertex v1 = new Vertex(10);
		Vertex v2 = new Vertex(1);
		Vertex v3 = new Vertex(12);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(9);
		Vertex v6 = new Vertex(19);
		// Combining path (edges)

		v1.edges.add(v2);
		//v2.edges.add(v1);
		//v1.edges.add(v3);
		v1.edges.add(v4);
		v1.edges.add(v5);
		v5.edges.add(v3);
		v3.edges.add(v6);
		graph.graph.add(v1);
		graph.graph.add(v2);
		graph.graph.add(v3);
		graph.graph.add(v4);
		graph.graph.add(v5);
		return graph;
	}
}
