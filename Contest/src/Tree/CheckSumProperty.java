/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 11-Apr-2013
 * 
 */
public class CheckSumProperty {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, null, null);
		Node n2 = new Node(3, null, null);
		Node n3 = new Node(8, n2, n1);
		Node n4 = new Node(1, null, null);
		Node n5 = new Node(3, n4, new Node(2, null, null));
		Node n = new Node(10, n3, n5);
		System.out.println((checkProperty(n,  true) == null)?false:true);
	}

	public static Node checkProperty(Node node,boolean isPropExists) {
		if (node == null) {
			return null;
		}
		int sum = 0;
		if (isPropExists) {
			Node left = checkProperty(node.left,isPropExists);
			Node rigth = checkProperty(node.right,isPropExists);
			if ((left == null) && (rigth == null)) {
				return node;
			}
			if (left != null) {
				sum += left.data;
			}
			if (rigth != null) {
				sum += rigth.data;
			}
			if (sum != node.data) {
				isPropExists = false;node = null;
			}
		}
		return node;
	}

	/*public static boolean checkProperty(Node head, boolean isPropTrue) {

		if (head == null) {
			return isPropTrue;
		}

		int headVal = head.data;
		isPropTrue = checkProperty(head.left, isPropTrue);
		if (isPropTrue) {

		}
		return isPropTrue;
	}*/
}
