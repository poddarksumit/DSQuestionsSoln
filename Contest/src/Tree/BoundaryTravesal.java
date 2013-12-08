/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 04-Dec-2013
 * 
 */
public class BoundaryTravesal {

	public static boolean boundaryTravesal(Node root, boolean firstReached) {
		if (root != null) {
			if ((!firstReached) && (root.left == null) && (root.right == null)) {
				firstReached = false;
				System.out.println(root.data);
				return false;
			}
			if (firstReached && (root.left != null)) {
				System.out.println(root.left.data);
			}
			firstReached = boundaryTravesal(root.left, firstReached);
			firstReached = boundaryTravesal(root.right, firstReached);
		}
		return firstReached;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(8, new Node(2, new Node(9, null, null), null),
				new Node(5, new Node(1, null, null), new Node(4, null, null)));
		Node n2 = new Node(20, new Node(15, null, null), new Node(25, null,
				null));
		Node root = new Node(10, n1, n2);
		boundaryTravesal(root, true);

	}
}
