/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 01-Dec-2013
 * 
 */
public class MaxRootToLeafSum {

	public static int findMaxRToLSum(Node root, int sum, int max) {
		if (root == null) {
			return max;
		}
		sum += root.data;
		max = findMaxRToLSum(root.left, sum, max);
		if (max < sum) {
			max = sum;
		}
		return findMaxRToLSum(root.right, sum, max);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(2, n1, n2);

		Node n111 = new Node(6, new Node(8, null, null), new Node(10, null,
				null));
		Node n211 = new Node(7, null, null);

		Node n11 = new Node(3, n111, n211);

		Node n5 = new Node(1, n3, n11);
		System.out.println(findMaxRToLSum(n5, 0, 0));

	}
}
