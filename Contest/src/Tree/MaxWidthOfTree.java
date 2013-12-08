/**
 * 
 */
package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is used to
 * 
 * @author Sumit 20-Nov-2013
 * 
 */
public class MaxWidthOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(4, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(2, n1, n2);
		Node n4 = new Node(3, new Node(8, new Node(6, null, null), new Node(7,
				null, null)), new Node(3));
		Node n5 = new Node(1, n3, n4);
		widthOfTree(n5);

	}

	public static void widthOfTree(Node root) {
		Node temp = root;
		Queue<Node> q = new LinkedList<Node>();
		int wid = 0;
		int max_wid = 0;
		int intlevel = 1;
		q.add(temp);
		q.add(null);
		while (!q.isEmpty()) {
			temp = q.remove();
			if (temp == null) {
				if (!q.isEmpty()) {
					q.add(null);
				}
				if (wid > max_wid) {
					max_wid = wid;
				}
				wid = 0;
				System.out.println("intlevel : " + intlevel);
				intlevel++;
			} else {
				wid++;
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		System.out.print(max_wid);
	}
}
