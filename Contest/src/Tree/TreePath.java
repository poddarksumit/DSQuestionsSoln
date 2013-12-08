/**
 * 
 */
package Tree;

import java.util.ArrayList;

/**
 * This class is used to
 * 
 * @author Sumit 07-Mar-2013
 * 
 */
public class TreePath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);
		ArrayList<Node> nodeLisr = new ArrayList<Node>();
		System.out.println(getPath(n5, nodeLisr));
	}

	public static ArrayList<Node> getPath(Node r, ArrayList<Node> l) {
		if (r == null) {
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i).data + ", ");

			}
			System.out.println(" ");
			l.remove(l.size() - 1);
			return l;
		}
		l.add(r);
		getPath(r.left, l);
		if (r.right != null) {
			getPath(r.right, l);
			l.remove(l.size() - 1);
		}
		return l;
	}
}
