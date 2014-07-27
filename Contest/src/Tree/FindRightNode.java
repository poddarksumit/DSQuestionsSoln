package Tree;

public class FindRightNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, null, null);
		Node n2 = new Node(3, null, null);
		Node n3 = new Node(8, n2, n1);
		Node n4 = new Node(1, null, null);
		Node n5 = new Node(3, n4, new Node(2, null, null));
		Node n = new Node(10, n3, n5);
		int k = findRight(n, 10, 1, 0);
		if (k > 0) {
			System.out.println("Found : " + k);
		} else {
			System.out.println("Not Found : " + k);
		}
		 k = findLeft(n, 1, 1, 0);
		if (k > 0) {
			System.out.println("Found : " + k);
		} else {
			System.out.println("Not Found : " + k);
		}

	}

	public static int findRight(Node root, int k, int height, int p) {
		if (root == null) {
			return p;
		}
		if (root.data == k) {
			return -height;
		}
		if (height == -(p)) {
			return root.data;
		}
		p = findRight(root.left, k, height + 1, p);
		p = findRight(root.right, k, height + 1, p);
		return p;
	}

	public static int findLeft(Node root, int k, int height, int p) {
		if (root == null) {
			return p;
		}
		if (root.data == k) {
			return -height;
		}
		if (height == -(p)) {
			return root.data;
		}
		p = findLeft(root.right, k, height + 1, p);
		p = findLeft(root.left, k, height + 1, p);
		return p;
	}
}
