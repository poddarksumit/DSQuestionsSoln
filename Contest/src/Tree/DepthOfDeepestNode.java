/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 19-Mar-2013
 * 
 */
public class DepthOfDeepestNode {

	static int maxVal = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);

		Node n111 = new Node(13, null, null);
		Node n112 = new Node(17, new Node(16, null, null), new Node(18, null,
				null));

		Node n11 = new Node(15, n111, n112);
		Node n12 = new Node(25, null, null);

		Node n4 = new Node(20, n11, n12);
		Node n5 = new Node(10, n3, n4);
		System.out.println(getDepth(n5, 1));
		System.out.println(getDepthOneLine(n5, 1));
	}

	public static int getDepth(Node root, int val) {
		if (root == null) {
			return val;
		}
		if ((val % 2 != 0) && (val > maxVal)) {
			maxVal = val;
		}
		getDepth(root.left, val + 1);
		getDepth(root.right, val + 1);
		return maxVal;
	}

	public static int getDepthOneLine(Node root, int val) {
		if (root == null) {
			return val;
		}

		return Math.max(getDepth(root.left, val + 1),
				getDepth(root.right, val + 1));
	}
}
