/**
 * 
 */
package Tree;

import java.util.HashMap;

/**
 * This class is used to
 * 
 * @author Sumit 15-Mar-2013
 * 
 */
public class VerticleSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(2, n1, n2);

		Node n111 = new Node(6, null, null);
		Node n211 = new Node(7, null, null);

		Node n11 = new Node(3, n111, n211);

		// Node n4 = new Node(23, n11, n21);

		Node n5 = new Node(1, n3, n11);
		HashMap<Integer, Integer> kMap = new HashMap<Integer, Integer>();
		getVerticleSum(n5, 0, kMap);
		System.out.println(kMap);

	}

	public static void getVerticleSum(Node root, int index,
			HashMap<Integer, Integer> kMap) {
		if (root != null) {
			getVerticleSum(root.left, index - 1, kMap);
			if (kMap.get(index) != null) {
				int k = kMap.get(index) + root.data;
				kMap.put(index, k);
			} else {
				kMap.put(index, root.data);
			}
			getVerticleSum(root.right, index + 1, kMap);
		}
	}

}
