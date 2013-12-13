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
public class Node {

	int data;
	boolean isVisited = false;
	Node left;
	Node leftMost;
	Node right;

	Node(int data) {
		super();
		this.data = data;
	}

	Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public Node() {
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

}
