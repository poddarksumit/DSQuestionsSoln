/**
 * 
 */
package List;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 16-Jun-2013
 * 
 */
public class SwapTwoOddNodes {
	static NodeList head = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// head = 1->2->3->4->5->6->7
		NodeList n = new NodeList(7, null);

		NodeList n1 = new NodeList(6, n);
		NodeList n2 = new NodeList(5, n1);
		NodeList n3 = new NodeList(4, n2);
		NodeList n4 = new NodeList(3, n3);
		NodeList n5 = new NodeList(2, n4);
		NodeList n6 = new NodeList(1, n5);

		head = n6;
		swap2Node(n6, n6.getNext(), null);
		System.out.println(head);
	}

	public static NodeList swap2Node(NodeList startNode, NodeList nextNode,
			NodeList prevNode) {

		if (nextNode == null) {
			return head;
		}
		NodeList bkpNode = null;
		if (prevNode == null) {
			bkpNode = nextNode.getNext();
			nextNode.setNext(null);
			head = nextNode;
			startNode.setNext(bkpNode);
			head.setNext(startNode);

		} else {
			bkpNode = nextNode.getNext();
			nextNode.setNext(null);
			startNode.setNext(bkpNode);
			prevNode.setNext(nextNode);
			prevNode.getNext().setNext(startNode);
		}

		if (startNode.getNext() != null) {
			swap2Node(startNode.getNext(), startNode.getNext().getNext(),
					startNode);

		}
		return null;
	}
}
