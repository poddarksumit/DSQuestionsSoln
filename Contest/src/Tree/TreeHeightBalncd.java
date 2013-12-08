/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 17-Nov-2013
 * 
 */
public class TreeHeightBalncd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, new Node(2, new Node(30, null, null), null),
				new Node(5, null, null));
		Node n2 = new Node(3, null, null);
		Node n3 = new Node(7, n2, n1);
		Node n4 = new Node(1, null, null);
		Node n5 = new Node(50, n4, new Node(30, null, null));
		Node n = new Node(50, n3, n5);
		int partn = treeHeightBalncd(n, 0);
		System.out.println(partn);

	}

	public static int treeHeightBalncd(Node tree, int height) {
		int hgt = height;
		if (height > -1) {
			if (tree.left != null) {
				hgt = treeHeightBalncd(tree.left, height + 1);
			}

			if (hgt > -1 && tree.right != null) {
				int heightTemp = treeHeightBalncd(tree.right, height + 1);
				if ((heightTemp - hgt) > 1) {
					hgt = -1;
				} else {
					if (heightTemp > hgt) {
						hgt = heightTemp;
					}

				}
			}

		}

		return hgt;
	}
}
