package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		depthFirstSearch(GraphImplementation.getGraph());
	}

	public static void depthFirstSearch(Graph graph) {
		if (graph != null && graph.graph != null && graph.graph.size() > 0) {
			Stack<Vertex> stack = new Stack<Vertex>();
			Vertex vertex = graph.graph.get(0);
			stack.add(vertex);
			while (!stack.isEmpty()) {
				vertex = stack.lastElement();
				if(vertex.myColor == GraphColor.WHITE){
					System.out.println(vertex.vertexPoint + " , ");
				}
				vertex.myColor = GraphColor.GRAY;
				boolean isEdgeUnVisisted = insertUnVisitedAtTimes(vertex, stack);
				if (!isEdgeUnVisisted) {
					vertex.myColor = GraphColor.BLACK;
					stack.remove(vertex);
				}
			}
		}
	}

	public static boolean insertUnVisitedAtTimes(Vertex vertes,
			Stack<Vertex> stack) {
		List<Vertex> edges = vertes.edges;
		boolean isEdgeUnVisisted = false;
		if (!edges.isEmpty()) {
			for (int i = 0; i < edges.size(); i++) {
				if (edges.get(i).myColor == GraphColor.WHITE) {
					isEdgeUnVisisted = true;
					stack.add(edges.get(i));
					break;
				}
			}
		}

		return isEdgeUnVisisted;
	}

}
