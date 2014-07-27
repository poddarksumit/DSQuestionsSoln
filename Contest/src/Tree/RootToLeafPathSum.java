package Tree;

public class RootToLeafPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, new Node(8, new Node(3, null, null), new Node(
				9, null, null)), new Node(6, new Node(2, new Node(10, null,
				null), new Node(15, null, null)), new Node(7, new Node(15,
				null, null), new Node(13, new Node(4, null, null), new Node(11,
				null, null)))));
		int sum = getRootLeafSumPath(root, 20, 0);
		System.out.println((sum == -1) ? true : false);
	}

	public static int getRootLeafSumPath(Node root, int sum, int sumTll) {
		if (sum > -1) {
			if (root == null) {
				if (sum == sumTll) {
					return -1;
				} else {
					return sum;
				}
			}
			sumTll += root.data;
			sum = getRootLeafSumPath(root.left, sum, sumTll);
			sum = getRootLeafSumPath(root.right, sum, sumTll);
		}
		return sum;
	}
}
