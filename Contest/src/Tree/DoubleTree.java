/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 30-Mar-2013
 * 
 */
public class DoubleTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(2, n1, n2);
		Node n4 = new Node(3, null, null);
		Node n5 = new Node(1, n3, n4);
		getDouble(n5);
	}

	public static Node getDouble(Node r) {
		if (r == null) {
			return null;
		}
		getDouble(r.left);
		Node z = r.left;
		Node y = new Node(r.data);
		y.left = z;
		r.left = y;
		getDouble(r.right);
		return r;
	}
}
