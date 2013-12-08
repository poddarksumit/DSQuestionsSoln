/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 28-Nov-2013
 * 
 */
public class ConnectLevelOrderNode {

	public static Node connectNode(Node root) {
		if (root == null) {
			return null;
		}
		if (root.left != null) {
			root.left.leftMost = root.right;
		}
		if (root.right != null) {
			root.right.leftMost = getRootValue(root);
		}
		connectNode(root.left);
		connectNode(root.right);
		return root;
	}

	public static Node getRootValue(Node root) {
		boolean found = false;
		Node temp = root.leftMost;
		Node foundNode = null;
		while ((!found) && (temp != null)) {
			if (temp.left != null) {
				found = true;
				foundNode = temp.left;
			} else if (temp.right != null) {
				found = true;
				foundNode = temp.right;
			} else {
				temp = temp.leftMost;
			}
		}
		return foundNode;
	}

	public static void main(String[] args) {
		Node n1 = new Node(2, new Node(1, null, null), new Node(4, null, null));
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);

		Node n111 = new Node(13, null, null);
		Node n112 = new Node(17, new Node(16, null, null), new Node(18, null,
				null));

		Node n11 = new Node(15, null, null);
		Node n12 = new Node(25, null, new Node(15, null, new Node(28, null,
				null)));

		Node n4 = new Node(20, n11, n12);
		Node n5 = new Node(10, n3, n4);
		Node root = connectNode(n5);
		System.out.println(root);
	}
}
