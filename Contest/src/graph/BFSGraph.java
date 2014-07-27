package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		breadthFirstSearch(GraphImplementation.getGraph());
	}

	public static void breadthFirstSearch(Graph graph) {
		if (graph != null && graph.graph != null && graph.graph.size() > 0) {
			Queue<Vertex> queue = new LinkedList<Vertex>();
			Vertex vertex = graph.graph.get(0);
			queue.add(vertex);
			while (!queue.isEmpty()) {
				vertex = queue.poll();
				vertex.myColor = GraphColor.GRAY;
				System.out.println(vertex.vertexPoint + " , ");
				insertAllUnVisited(vertex, queue);
				vertex.myColor = GraphColor.BLACK;
			}
		}
	}

	public static void insertAllUnVisited(Vertex vertex, Queue<Vertex> queue) {
		List<Vertex> edges = vertex.edges;
		if (!edges.isEmpty()) {
			for (int i = 0; i < edges.size(); i++) {
				if (edges.get(i).myColor == GraphColor.WHITE) {
					queue.add(edges.get(i));
				}
			}
		}

	}

}
