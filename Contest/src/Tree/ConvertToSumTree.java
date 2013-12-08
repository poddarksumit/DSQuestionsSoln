/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 30-Nov-2013
 * 
 */
public class ConvertToSumTree {

	private static Node convertSum(Node root, Node head) {
		if (root == null) {
			return null;
		}
		if ((root.left == null) && (root.right == null)) {
			return null;
		}
		Node l = convertSum(root.left, head);
		if (l == null) {
			l = new Node(root.left.data, null, null);
			root.left.data = 0;
		}
		Node r = convertSum(root.right, head);
		if (r == null) {
			r = new Node(root.right.data, null, null);
			root.right.data = 0;
		}
		Node temp = new Node(root.data + l.data + r.data, null, null);
		root.data = l.data + r.data;
		return temp;
	}

	private static int convertSum1(Node root, Node head) {
		if (root == null) {
			return 0;
		}
		int old = root.data;
		root.data = convertSum1(root.left, head)
				+ convertSum1(root.right, head);

		return root.data = root.data + old;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(10, new Node(5, new Node(3, null, null), new Node(
				-1, null, null)), new Node(-6, new Node(4, null, null),
				new Node(-2, null, null)));
		int x = convertSum1(n5, n5);
		System.out.println(n5);
	}
}
