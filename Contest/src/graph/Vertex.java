package graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	int vertexPoint = -1;
	GraphColor myColor = GraphColor.WHITE;
	List<Vertex> edges = new ArrayList<Vertex>();

	public Vertex(int vertexPoint) {
		super();
		this.vertexPoint = vertexPoint;
	}

	public int getVertexPoint() {
		return vertexPoint;
	}

	public void setVertexPoint(int vertexPoint) {
		this.vertexPoint = vertexPoint;
	}

	public Vertex() {
		super();
		// TODO Auto-generated constructor stub
	}

}
