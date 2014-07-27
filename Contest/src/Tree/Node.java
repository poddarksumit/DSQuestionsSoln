/**
 * 
 */
package Tree;


/**
 * This class is used to
 * 
 * @author Sumit 10-Nov-2013
 * 
 */
public class Node  {

	int data;
	boolean isVisited = false;
	Node left;
	Node leftMost;
	Node right;

	Node(int data) {
		super();
		this.data = data;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	

	public Node(int data, Node left, Node right, Node leftMost,
			boolean isVisited) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.leftMost = leftMost;
		this.isVisited = isVisited;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getLeftMost() {
		return leftMost;
	}

	public void setLeftMost(Node leftMost) {
		this.leftMost = leftMost;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	

}
