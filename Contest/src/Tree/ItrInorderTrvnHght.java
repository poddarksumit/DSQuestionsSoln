/**
 * 
 */
package Tree;

import java.util.Stack;

/**
 * This class is used to
 * 
 * @author Sumit 07-Dec-2013
 * 
 */
public class ItrInorderTrvnHght {

	public static void iterativeInorder(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		root = root.left;
		boolean isDone = false;
		while (!isDone) {
			if (root != null) {
				s.push(root);
				root = root.left;
			} else {
				if (!s.isEmpty()) {
					Node clc = s.pop();
					System.out.println(clc.data);
					root = clc.right;
				} else {
					isDone = true;
				}
			}
		}
	}

	public static void iterativeInorderHeight(Node root) {
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		root = root.left;
		int max = 0, x = 1;
		boolean isDone = false;
		while (!isDone) {
			if (root != null) {
				x += 1;
				s.push(root);
				root = root.left;
			} else {
				if (!s.isEmpty()) {
					if (max < x) {
						max = x;
					}
					if (x > 1) {
						x -= 1;
					}
					Node clc = s.pop();
					System.out.println(clc.data);
					root = clc.right;
				} else {
					System.out.println("max : " + max);
					isDone = true;
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(10, new Node(6, new Node(3, null, null), new Node(8,
				null, null)), new Node(15, new Node(13, new Node(3, new Node(8,
				null, null), null), new Node(3, null, null)), new Node(20,
				null, null)));
		iterativeInorder(n5);
		iterativeInorderHeight(n5);
	}
}
