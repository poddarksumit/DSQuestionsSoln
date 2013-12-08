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
public class IterativePostOrder {

	public static void itrPostOrder(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		s1.push(root);
		Stack<Node> s2 = new Stack<Node>();
		while ((!s1.isEmpty()) || (!s2.isEmpty())) {
			boolean is = false;
			Node r = s1.pop();
			s2.push(r);
			if (r.right != null) {
				s1.push(r.right);
				is = true;
			}
			if (r.left != null) {
				s1.push(r.left);
				is = true;
			}

			if (!is) {
				System.out.println(r.data);
				System.out.println(s2.pop().data);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(10, new Node(6, new Node(3, null, null), new Node(8,
				null, null)), new Node(15, new Node(13, null, null), new Node(
				20, null, null)));
		itrPostOrder(n5);

	}

}
