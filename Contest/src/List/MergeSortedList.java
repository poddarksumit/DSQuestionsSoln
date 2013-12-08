/**
 * 
 */
package List;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 19-Mar-2013
 * 
 */
public class MergeSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeList n1 = new NodeList(2);
		n1.setNext(new NodeList(3));
		n1.getNext().setNext(new NodeList(20));

		NodeList n2 = new NodeList(5);
		n2.setNext(new NodeList(10));
		n2.getNext().setNext(new NodeList(15));

		n1 = getMergedSortRecurr(n1, n2);
		System.out.println(n1);
	}

	public static NodeList getMergedSort(NodeList n1, NodeList n2) {
		NodeList nTemp = null;
		if (n1 == null) {
			nTemp = n2;
		} else if (n2 == null) {
			nTemp = n1;
		} else {
			nTemp = n1;
			NodeList temp = null;
			while ((n1 != null) && (n2 != null)) {
				if (n1.getData() > n2.getData()) {
					NodeList n1Temp = n1.getNext();
					n1.setNext(null);
					temp.setNext(n2);
					temp.getNext().setNext(n1Temp);
					n1 = temp.getNext();
					n2 = n2.getNext();
				}
				temp = n1;
				n1 = n1.getNext();

			}
			if ((n1 == null) && (n2 != null)) {
				temp.setNext(n2);
			}
		}
		return nTemp;
	}

	public static NodeList getMergedSortRecurr(NodeList n1, NodeList n2) {
		NodeList result;
		if (n1 == null)
			return (n2);
		else if (n2 == null)
			return (n1);

		/* Pick either a or b, and recur */
		if (n1.getData() <= n2.getData()) {
			result = n1;
			result.setNext(getMergedSortRecurr(n1.getNext(), n2));
		} else {
			result = n2;
			result.setNext(getMergedSortRecurr(n1, n2.getNext()));

		}
		return (result);
	}
}
