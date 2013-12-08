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
public class MoveLastToFront {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList n1 = new NodeList(5, null);
		NodeList n2 = new NodeList(4, n1);
		NodeList n3 = new NodeList(3, n2);
		NodeList n4 = new NodeList(2, n3);
		NodeList n5 = new NodeList(1, n4);
		NodeList n = moveLastToFront(n5);
	}

	public static NodeList moveLastToFront(NodeList root) {
		NodeList n = root;
		while ((root.getNext() != null) && (root.getNext().getNext() != null)) {
			root = root.getNext();
		}
		NodeList nRoot = root.getNext();
		root.setNext(null);
		nRoot.setNext(n);
		return nRoot;

	}
}
