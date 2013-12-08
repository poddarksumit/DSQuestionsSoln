/**
 * 
 */
package List;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 07-Apr-2013
 * 
 */
public class ReverseList {
	private static NodeList h;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList n1 = new NodeList(5, null);
		NodeList n2 = new NodeList(4, n1);
		NodeList n3 = new NodeList(3, n2);
		NodeList n4 = new NodeList(2, n3);
		NodeList n5 = new NodeList(1, n4);
		NodeList n = reverseList(n5, null);
	}

	public static NodeList reverseList(NodeList l, NodeList a) {
		if (l == null) {
			return a;
		}
		a = reverseList(l.getNext(), a);
		if (a == null) {
			a = new NodeList(l.getData());
			h = a;
		} else {
			a.setNext(new NodeList(l.getData()));
			a = a.getNext();
		}
		return a;
	}
}
