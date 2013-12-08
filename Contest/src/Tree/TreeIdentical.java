/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 27-Aug-2013
 * 
 */
public class TreeIdentical {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(8, null, null);
		Node n3 = new Node(5, n1, n2);
		Node n111 = new Node(16, null, null);
		Node n211 = new Node(22, null, null);
		Node n11 = new Node(21, n111, n211);
		Node n5 = new Node(10, n3, n11);

		Node n1_1 = new Node(2, null, null);
		Node n2_1 = new Node(8, null, null);
		Node n3_1 = new Node(5, n1_1, n2_1);
		Node n111_1 = new Node(16, null, null);
		Node n211_1 = new Node(22, null, null);
		Node n11_1 = new Node(21, null, null);
		Node n5_1 = new Node(10, n3_1, n11_1);

		System.out.println(isTreeIdentical(n5, n5_1, true));
	}

	public static boolean isTreeIdentical(Node x, Node y,
			boolean isTreeIdentical) {
		if ((x == null) && (y == null)) {
			return isTreeIdentical;
		}
		if (((x == null) && (y != null)) || ((x != null) && (y == null))) {
			return false;
		}
		isTreeIdentical = isTreeIdentical(x.left, y.left, isTreeIdentical);
		if ((isTreeIdentical) && (x.data != y.data)) {
			isTreeIdentical = false;
		}
		if (isTreeIdentical) {
			isTreeIdentical = isTreeIdentical(x.right, y.right, isTreeIdentical);
		}
		return isTreeIdentical;
	}
}
