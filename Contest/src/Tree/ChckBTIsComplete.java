/**
 * 
 */
package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is used to
 * 
 * @author Sumit 04-Dec-2013
 * 
 */
public class ChckBTIsComplete {

	public static boolean isBtComplete(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		boolean isValid = true;
		int count = -1;
		while ((isValid) && (!queue.isEmpty())) {
			Node x = queue.poll();
			if ((x != null) && ((x.left != null) || (x.right != null))) {
				if (count != 0) {
					count = -1;
					if (x.left != null) {
						queue.add(x.left);
						count = 0;
					}
					if (x.right != null) {
						if (count == 0) {
							queue.add(x.right);
							count = 1;
						} else {
							isValid = false;
						}
					}
				} else {
					isValid = false;
				}
			}
		}
		return isValid;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(8, new Node(2, new Node(8, null, null), null),
				new Node(5, null, null));
		Node n2 = new Node(20, new Node(8, null, null), new Node(8, null, null));
		Node root = new Node(10, n1, n2);
		System.out.println(isBtComplete(root));

	}
}
