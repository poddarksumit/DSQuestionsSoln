/**
 * 
 */
package Tree;

import java.util.HashMap;

/**
 * This class is used to
 * 
 * @author Sumit 01-Dec-2013
 * 
 */
public class DeepestLeftLeafNode {

	public static int getDeepestLeftNode(Node root, boolean isLeft, int heigth,
			int max, HashMap<Integer, Node> pathMap) {
		if (root == null) {
			return max;
		}
		heigth += 1;
		max = getDeepestLeftNode(root.left, true, heigth, max, pathMap);
		if ((isLeft) && (max < heigth)) {
			max = heigth;
			pathMap.put(max, root);
		}
		max = getDeepestLeftNode(root.right, false, heigth, max, pathMap);
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(1, new Node(2, new Node(4, null, null), null),
				new Node(3, new Node(5, null, new Node(7, new Node(9, null,
						null), null)), new Node(6, null, new Node(8, null,
						new Node(10, new Node(11, null, null), new Node(12,
								null, null))))));
		Node result = new Node(0);
		HashMap<Integer, Node> pathMap = new HashMap<Integer, Node>();
		int x = getDeepestLeftNode(n1, false, 0, 0, pathMap);
		System.out.println(x + " " + pathMap.get(x).data);
	}
}
