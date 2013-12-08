/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 23-Nov-2013
 * 
 */
public class GetLevelOfNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(8, null, null);
		Node n3 = new Node(5, n1, n2);

		Node n111 = new Node(16, null, null);
		Node n211 = new Node(22, null, null);

		Node n11 = new Node(21, n111, n211);
		Node n21 = new Node(25, null, null);

		Node n4 = new Node(23, n11, n21);

		// Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);

		System.out.println(findLevelKey(n5, 10, 0, 1));

	}

	public static int findLevelKey(Node root, int data, int levTemp, int lev) {
		if (root == null) {
			return levTemp;
		}
		levTemp = findLevelKey(root.left, data, levTemp, lev + 1);
		if (levTemp == 0) {
			if (root.data == data) {
				return lev;
			}
		} else {
			return levTemp;
		}
		return findLevelKey(root.right, data, levTemp, lev + 1);
	}
}
