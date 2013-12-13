package Tree;

public class RemoveNodeSumLsThnKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4, new Node(8, new Node(1,
				null, null), null), new Node(9, new Node(13, null, null),
				new Node(14, new Node(15, null, null), null))), new Node(5,
				new Node(12, null, null), null)), new Node(3, new Node(6, null,
				null), new Node(7,
				new Node(10, null, new Node(11, null, null)), null)));
		System.out.println(root.data);
		process(root, root, 20, 0);
		System.out.println(root.data);
	}

	public static void process(Node root, Node prev, int key, int sum) {
		if (root != null) {
			sum += root.data;
			process(root.left, root, key, sum);
			if ((root.left == null) && (root.right == null)) {
				if (sum < key) {
					prev.left = null;
				}
			}
			process(root.right, root, key, sum);
			if ((root.left == null) && (root.right == null)) {
				if (sum < key) {
					prev.right = null;
				}
			}
		}
	}
}
