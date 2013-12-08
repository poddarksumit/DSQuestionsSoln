/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 23-Nov-2013
 * 
 */
public class InorderSuccessor {

	private static Node getnorderSUccessor(Node root) {
		if (root.left != null) {
			return getnorderSUccessor(root.left);
		} else {
			return root;
		}

	}

	private static Node inorderSUccessor(Node root, int key) {
		if (root == null) {
			return null;
		}
		Node temp = null;
		if (key < root.data) {
			temp = inorderSUccessor(root.left, key);
		} else if (key > root.data) {
			temp = inorderSUccessor(root.right, key);
		} else if (key == root.data) {
			if (root.right != null) {
				temp = getnorderSUccessor(root.right);
			} else {
				temp = root;
				return temp;
			}
		}
		if ((temp != null) && (temp.data == key)) {
			if (root.data > key) {
				temp = root;
			}
		}
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(12, new Node(10, null, null), new Node(14, null,
				null));
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(22, null, null);
		Node n5 = new Node(20, n3, n4);
		Node succ = inorderSUccessor(n5, 20);
		System.out.println(succ.data);
	}
}
