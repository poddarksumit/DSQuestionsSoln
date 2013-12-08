/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 08-Nov-2013
 * 
 */
public class LCA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(10, null, null);
		Node n3 = new Node(14, null, null);
		Node n4 = new Node(12, n2, n3);
		Node n5 = new Node(8, n1, n4);
		Node n6 = new Node(22, null, null);
		Node n7 = new Node(20, n5, n6);

		System.out.println(performLCA(n7, 1, 2));
	}

	public static int performLCA(Node node, int n1, int n2) {
		int shortst = node.data;
		boolean isNtFound = true;
		while ((isNtFound) && (node != null)) {
			if (node.data < shortst) {
				shortst = node.data;
			}
			if (n1 < node.data && node.data < n2) {
				isNtFound = false;
			} else if (node.data < n1 && node.data < n2) {
				node = node.right;
			} else if (node.data > n1 && node.data > n2) {
				node = node.left;
			}
		}
		if (isNtFound) {
			shortst = -1;
		}
		return shortst;
	}

}
