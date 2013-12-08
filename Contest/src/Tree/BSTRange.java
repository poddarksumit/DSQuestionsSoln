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
public class BSTRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);

		printBSTForRange(n5, 6, 14);
	}

	public static Node printBSTForRange(Node r, int k1, int k2) {
		if ((r == null) || ((r.data < k1) || (r.data > k2))) {
			return null;
		}
		printBSTForRange(r.left, k1, k2);
		if ((r.data >= k1) || (r.data <= k2)) {
			System.out.println(r.data);
		}
		printBSTForRange(r.right, k1, k2);
		return r;
	}
}
