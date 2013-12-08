/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 08-Mar-2013
 * 
 */
public class BTIsBST {

	public static boolean isBTBST(Node root, Node prev) {
		if (root != null) {
			if (!isBTBST(root.left, prev)) {
				return false;
			}
			if ((prev != null) && (prev.data > root.data)) {
				return false;
			} else {
				prev = root;
			}
			return isBTBST(root.right, prev);
		} else {
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(10, new Node(5, new Node(4, null, null), new Node(
				9, null, null)),
				new Node(20, new Node(15, null, null), new Node(25, new Node(
						21, null, null), new Node(28, null, null))));
		System.out.println(isBTBST(root, null));
	}
}
