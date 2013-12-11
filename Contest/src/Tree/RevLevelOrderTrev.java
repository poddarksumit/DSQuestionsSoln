package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RevLevelOrderTrev {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, new Node(6, null, null), new Node(7, null, null));
		Node n2 = new Node(3, new Node(10, null, null),
				new Node(25, null, null));
		Node n3 = new Node(8, n1, n2);
		traverseRev(n3);

	}

	public static void traverseRev(Node node) {
		Stack<Node> stck = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node r = queue.poll();
			stck.add(r);
			if (r.right != null) {
				queue.add(r.right);
			}
			if (r.left != null) {
				queue.add(r.left);
			}
		}

		while (!stck.isEmpty()) {
			System.out.println(stck.pop().data);
		}
	}
}
