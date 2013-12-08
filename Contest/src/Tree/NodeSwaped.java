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
public class NodeSwaped {

	static Node frst = null;
	static Node prev = null;
	static Node scd = null;

	public static Node getNodeSwappedCorrect(Node root) {
		if (root != null) {
			getNodeSwappedCorrect(root.left);
			if ((prev != null) && (root.data < prev.data)) {
				if (frst == null) {
					frst = new Node(prev.data);
					scd = new Node(root.data);
					System.out.println(frst.data);
					System.out.println(scd.data);
				} else {
					scd = new Node(root.data);
					System.out.println(scd.data);
					return null;
				}
			}
			prev = root;
			getNodeSwappedCorrect(root.right);
		}
		return root;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, new Node(6, null, null), new Node(7, null, null));
		Node n2 = new Node(3, new Node(10, null, null),
				new Node(25, null, null));
		Node n3 = new Node(8, n1, n2);
		Node n = getNodeSwappedCorrect(n3);
	}
}
