/**
 * 
 */
package List;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 21-Mar-2013
 * 
 */
public class DeleteAlternateNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList r = new NodeList(0);
		NodeList rTemp = r;
		r.setNext(new NodeList(1));
		r.getNext().setNext(new NodeList(2));
		r.getNext().getNext().setNext(new NodeList(3));

		deleteNode(r, rTemp, 1);

		System.out.println();
	}

	public static NodeList deleteNode(NodeList r, NodeList prev, int v) {
		if (r == null) {
			return null;
		}
		if (v % 2 == 0) {
			prev.setNext(r.getNext());

		}
		return deleteNode(r.getNext(), r, v + 1);
	}
}
