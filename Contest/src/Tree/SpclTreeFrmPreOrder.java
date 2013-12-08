/**
 * 
 */
package Tree;

import java.util.Stack;

/**
 * This class is used to
 * 
 * @author Sumit 02-Dec-2013
 * 
 */
public class SpclTreeFrmPreOrder {

	private static Node buildFullTree(Node root, int[] pre, String[] preLN,
			int index, Stack<Node> stack) {
		while (!stack.isEmpty()) {
			root = stack.peek();
			if (root.left == null) {
				root.left = new Node(pre[index]);
				if (preLN[index].equals("N")) {
					stack.push(root.left);
				}
				index++;
			} else {
				root.right = new Node(pre[index]);
				index++;
				stack.pop();
			}
		}
		return root;
	}

	private static Node buildTree(int[] pre, String[] preLN) {
		Node root = null;
		if (pre.length > 0) {
			root = new Node(pre[0]);
			if ((pre.length > 1) || ("N".equals(preLN[0]))) {
				Stack<Node> stack = new Stack<Node>();
				stack.push(root);
				root = buildFullTree(root, pre, preLN, 1, stack);
			}
		}
		return root;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int pre[] = { 10, 30, 20, 5, 15 };
		String preLN[] = { "N", "L", "L", "L", "L" };
		Node c = buildTree(pre, preLN);
		System.out.println(c);

	}
}
