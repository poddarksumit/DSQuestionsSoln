/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 06-Mar-2013
 * 
 */
public class TreeMirror {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);

		Node r = getMirrorTree(n5);
		System.out.println(r);
	}

	public static Node getMirrorTree(Node r) {
		if (r == null) {
			return null;
		}
		Node x = getMirrorTree(r.right);
		Node y = new Node(r.data);
		if (x != null) {
			y.left = new Node(x.data);
		}
		y.right = getMirrorTree(r.left);
		return y;

	}
}
