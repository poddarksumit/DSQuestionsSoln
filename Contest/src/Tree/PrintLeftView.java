package Tree;

public class PrintLeftView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(12, new Node(10, null, null), new Node(30, new Node(
				25, null, null), new Node(40, null, null)));
		printLeftView(n5);

	}

	public static void printLeftView(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.println(root.left.data);
				printLeftView(root.left);
			}
			printLeftView(root.right);
		}
	}
}
