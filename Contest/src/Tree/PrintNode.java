/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 16-Mar-2013
 * 
 */
public class PrintNode {
	static boolean isNodeFound = false;
	static int nodeHeight = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node(12, null, null);
		Node b = new Node(13, null, null);
		Node n1011 = new Node(10, null, null);
		Node n101a1 = new Node(11, a, b);
		Node n10111 = new Node(8, null, null);
		Node n101111 = new Node(9, null, null);
		Node n10 = new Node(6, null, null);
		Node n101 = new Node(7, n1011, n101a1);
		Node n11 = new Node(5, n10111, n101111);
		Node n12 = new Node(4, null, null);
		Node n1 = new Node(2, n12, n11);
		Node n2 = new Node(3, n10, n101);
		Node n3 = new Node(1, n1, n2);
		printKNode(n3, new Node(6), 4);
	}

	public static void printKNode(Node root, Node n, int k) {
		printKNode(root, n, k, 0);

	}

	public static void printKNode(Node root, Node n, int k, int height) {
		if (root != null) {
			height += 1;
			if ((!isNodeFound) && (root.data == n.data)) {
				isNodeFound = true;
				nodeHeight = height;
			}
			if (k == 0) {
				System.out.println(root.data);
				return;
			} else {
				if (isNodeFound) {
					printKNode(root.left, n, k - 1, height);
				} else {
					printKNode(root.left, n, k, height);
				}
				if (isNodeFound) {
					if (height < nodeHeight) {
						k -= 1;
					}
					printKNode(root.right, n, k - 1, height);

				} else {

					printKNode(root.right, n, k, height);
				}
			}
		}
	}
}
