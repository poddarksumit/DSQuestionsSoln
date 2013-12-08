/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 23-Jun-2013
 * 
 */
public class SizeOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println(getSizeOfTree(n5, 0));
		System.out.println(getSizeOfTreeInOrd(n5, 0));
	}

	public static int getSizeOfTree(Node array, int count) {
		if (array == null) {
			return count;
		}
		count = getSizeOfTree(array.left, count);
		count += 1;
		count = getSizeOfTree(array.right, count);
		return count;
	}

	public static int getSizeOfTreeInOrd(Node array, int count) {
		if (array == null) {
			return count;
		}
		count += 1;
		count = getSizeOfTree(array.left, count);
		count = getSizeOfTree(array.right, count);
		return count;
	}
}
