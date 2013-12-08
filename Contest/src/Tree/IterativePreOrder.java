/**
 * 
 */
package Tree;

import java.util.Stack;

/**
 * This class is used to
 * 
 * @author Sumit 06-Dec-2013
 * 
 */
public class IterativePreOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(10, new Node(6, new Node(3, null, null), new Node(8,
				null, null)), new Node(15, new Node(13, null, null), new Node(
				20, null, null)));
		preorderItr(n5);

	}

	public static void preorderItr(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		Node r = null;
		while (!s.isEmpty()) {
			r = s.pop();
			System.out.println(r.data);
			if (r.right != null) {
				s.push(r.right);
			}
			if (r.left != null) {
				s.push(r.left);
			}
		}
	}
}
