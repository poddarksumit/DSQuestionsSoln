/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 06-Dec-2013
 * 
 */
public class ConvertBSTToBTSumGrt {

	public static int findSum(Node root, int sum) {
		if (root == null) {
			return 0;
		}
		sum += findSum(root.right, sum);
		int sumTemp = findSum(root.left, sum + root.data);
		sum += root.data;
		root.data = sum;
		return (sumTemp == 0) ? sum : sumTemp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n5 = new Node(10, new Node(6, new Node(3, null, null), new Node(8,
				null, null)), new Node(15, new Node(13, null, null), new Node(
				20, null, null)));
		findSum(n5, 0);
		System.out.println(n5);

	}
}
