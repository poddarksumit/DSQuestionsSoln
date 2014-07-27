package Tree;

public class PrintSiblings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4, null, null), new Node(
				5, null, null)), new Node(3, new Node(6, null, null), new Node(
				7, null, null)));
		int heght = getLevel(root, 1, -1, 3);
		printSiblings(root, 1, heght);
	}

	public static int getLevel(Node root, int h, int pHeight, int value) {
		if ((root == null) || (pHeight > -1)) {
			return pHeight;
		}
		if (root.data == value) {
			return h;
		}
		pHeight = getLevel(root.left, h + 1, pHeight, value);
		pHeight = getLevel(root.right, h + 1, pHeight, value);
		return pHeight;
	}

	public static void printSiblings(Node root, int height, int pHeight) {
		if ((root != null) && (height <= pHeight)) {
			if (height == pHeight) {
				System.err.println(root.data);
			}
			printSiblings(root.left, height + 1, pHeight);
			printSiblings(root.right, height + 1, pHeight);
		}
	}
}
