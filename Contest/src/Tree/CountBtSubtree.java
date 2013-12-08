/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 30-Nov-2013
 * 
 */
public class CountBtSubtree {

	public static int getCountOfSubTree(Node root, Node prev, int count) {
		if (root != null) {
			count = getCountOfSubTree(root.left, prev, count);
			if ((prev != null) && (prev.data > root.data)) {
				count = 0;
			} else {
				prev = root;
				count += 1;
			}
			count = getCountOfSubTree(root.right, prev, count);
			return count;
		} else {
			return count;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(10, new Node(5, new Node(4, null, null), new Node(
				9, null, null)),
				new Node(20, new Node(15, null, null), new Node(25, new Node(
						30, null, null), new Node(28, null, null))));
		Node prev = null;
		System.out.println(getCountOfSubTree(root, prev, 0));

	}

}
