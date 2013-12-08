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
public class PairWiseSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// NodeList rootTemp = root;
	}

	public static NodeList getSwapped(NodeList root) {
		NodeList n1 = root;
		NodeList n2 = root.getNext();
		NodeList prev = null;
		while ((n2.getNext() == null) && (n2.getNext().getNext() == null)) {
			
			NodeList rootTemp = n2.getNext();
			n2.setNext(null);
			n1.
		}
	}
}
