/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 29-Jun-2013
 * 
 */
public class PrintAncestor {

	public static boolean found = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(9, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);
		printAncestorBST(n5, new Node(9), false);

		n1 = new Node(4, new Node(7, null, null), null);
		n2 = new Node(5, null, null);
		n3 = new Node(2, n1, n2);
		n4 = new Node(3, null, null);
		n5 = new Node(1, n3, n4);
		printAncestorBT(n5, new Node(7), false);

	}

	public static boolean printAncestorBST(Node root, Node toFind, boolean found) {
		if (root == null) {
			return found;
		}
		if ((!found) && (root.data == toFind.data)) {
			return true;
		}
		if ((!found) && (root.data >= toFind.data)) {
			found = printAncestorBST(root.left, toFind, found);
		}
		if ((!found) && (root.data <= toFind.data)) {
			found = printAncestorBST(root.right, toFind, found);
		}
		if (found) {
			System.out.println(root.data);
		}
		return found;
	}

	public static boolean printAncestorBT(Node root, Node toFind, boolean found) {
		if (root == null) {
			return found;
		}
		if ((!found) && (root.data == toFind.data)) {
			return true;
		}
		if (!found) {
			found = printAncestorBT(root.left, toFind, found);
		}
		if (!found) {
			found = printAncestorBT(root.right, toFind, found);
		}
		if (found) {
			System.out.println(root.data);
		}
		return found;
	}
}
