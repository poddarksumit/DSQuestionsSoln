package graph;

public class Edge {

	Vertex startNode;
	Vertex endNode;
	int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Edge() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vertex getStartNode() {
		return startNode;
	}

	public void setStartNode(Vertex startNode) {
		this.startNode = startNode;
	}

	public Vertex getEndNode() {
		return endNode;
	}

	public void setEndNode(Vertex endNode) {
		this.endNode = endNode;
	}

}
