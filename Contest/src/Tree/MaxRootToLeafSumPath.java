/**
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is used to
 * 
 * @author Sumit 01-Dec-2013
 * 
 */
public class MaxRootToLeafSumPath {

	public static int findMaxRToLSum(Node root, int sum, int max,
			ArrayList<Node> rootPath, HashMap<Integer, ArrayList<Node>> pathMap) {
		if (root == null) {
			return max;
		}
		sum += root.data;
		rootPath.add(root);
		max = findMaxRToLSum(root.left, sum, max, rootPath, pathMap);
		if (max < sum) {
			max = sum;
			ArrayList<Node> rootPathTemp = new ArrayList<Node>(rootPath);
			pathMap.put(max, rootPathTemp);
		}
		max = findMaxRToLSum(root.right, sum, max, rootPath, pathMap);
		rootPath.remove(rootPath.size() - 1);
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(2, n1, n2);

		Node n111 = new Node(6, new Node(8, null, null), new Node(10, null,
				null));
		Node n211 = new Node(7, null, null);

		Node n11 = new Node(3, n111, n211);

		Node n5 = new Node(1, n3, n11);
		HashMap<Integer, ArrayList<Node>> pathMap = new HashMap<Integer, ArrayList<Node>>();
		ArrayList<Node> rootPath = new ArrayList<Node>();
		int x = findMaxRToLSum(n5, 0, 0, rootPath, pathMap);
		ArrayList<Node> path = pathMap.get(x);
		System.out.println(path);
	}
}
