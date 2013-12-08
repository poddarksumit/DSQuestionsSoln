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
public class IntersectionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList n1 = new NodeList(2);
		n1.setNext(new NodeList(3));
		n1.getNext().setNext(new NodeList(20));
		n1.getNext().getNext().setNext(new NodeList(25));
		n1.getNext().getNext().getNext().setNext(new NodeList(30));

		NodeList n2 = new NodeList(5);
		n2.setNext(new NodeList(10));
		n2.getNext().setNext(new NodeList(20));
		n2.getNext().getNext().setNext(new NodeList(26));
		n2.getNext().getNext().getNext().setNext(new NodeList(30));

		// NodeList ntemp = getIntersection(n1, n2);
		NodeList ntemp = getIntersectionRecurr(n1, n2, null, null);
	}

	public static NodeList getIntersection(NodeList n1, NodeList n2) {
		NodeList temp = null;
		NodeList res = null;
		while ((n1 != null) && (n2 != null)) {
			if (n1.getData() < n2.getData()) {
				n1 = n1.getNext();
			} else if (n1.getData() > n2.getData()) {
				n2 = n2.getNext();
			} else {
				if ((res == null) && (temp == null)) {
					res = new NodeList(n1.getData());
					temp = res;
				} else {
					res.setNext(new NodeList(n1.getData()));
					res = res.getNext();
				}
				n1 = n1.getNext();
				n2 = n2.getNext();
			}
		}
		return temp;
	}

	public static NodeList getIntersectionRecurr(NodeList n1, NodeList n2,
			NodeList nTemp, NodeList nHead) {
		if ((n1 == null) || (n2 == null)) {
			return nHead;
		}

		if (n1.getData() == n2.getData()) {
			if ((nTemp == null) && (nHead == null)) {
				nTemp = new NodeList(n1.getData());
				nHead = nTemp;
			} else {
				nTemp.setNext(new NodeList(n1.getData()));
				nTemp = nTemp.getNext();
			}
			n1 = n1.getNext();
			n2 = n2.getNext();
			return getIntersectionRecurr(n1, n2, nTemp, nHead);
		}
		if (n1.getData() < n2.getData()) {
			return getIntersectionRecurr(n1.getNext(), n2, nTemp, nHead);
		} else {
			return getIntersectionRecurr(n1, n2.getNext(), nTemp, nHead);
		}
	}
}
