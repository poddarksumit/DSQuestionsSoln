/**
 * 
 */
package List;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 20-Mar-2013
 * 
 */
public class AlternateSplit {
	static NodeList aHead = null, bHead = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList r = new NodeList(0);
		r.setNext(new NodeList(1));
		r.getNext().setNext(new NodeList(2));
		r.getNext().getNext().setNext(new NodeList(3));
		getAlternateSplit(r, 1, null, null);
		System.out.println();
	}

	public static NodeList getAlternateSplit(NodeList r, int v, NodeList a,
			NodeList b) {
		if (r == null) {
			return null;
		}
		if (v % 2 == 0) {
			if (a == null) {
				a = new NodeList(r.getData());
				aHead = a;
			} else {
				a.setNext(new NodeList(r.getData()));
				a = a.getNext();
			}
		} else {
			if (b == null) {
				b = new NodeList(r.getData());
				bHead = b;
			} else {
				b.setNext(new NodeList(r.getData()));
				b = b.getNext();
			}
		}
		return getAlternateSplit(r.getNext(), v + 1, a, b);
	}
}
