package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintAncestorItr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(9, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, new Node(15, new Node(12, null, null), new Node(
				16, null, null)), new Node(18, null, null));
		Node n5 = new Node(10, n3, n4);
		printAncestor(n5, 15);

	}

	public static void printAncestor(Node root, int key) {
		Stack<Node> stack = new Stack<Node>();
		Node curr = root;
		boolean found = false;
		boolean done = false;
		while ((!found) && (!done)) {
			if (curr != null) {
				if (key == curr.data) {
					found = true;
				} else {
					stack.push(curr);
					curr = curr.left;
				}
			} else {
				if (!stack.isEmpty()) {
					Node rootTemp = stack.peek();
					if (rootTemp.right != null && !rootTemp.right.isVisited) {
						curr = rootTemp.right;
					} else {
						stack.pop();
						curr = null;
					}
				} else {
					done = true;
				}
			}
			if (curr != null) {
				curr.isVisited = true;
			}
		}
		while ((found) && (!stack.isEmpty())) {
			System.out.println(stack.pop().data);
		}
	}
}
