/**
 * 
 */
package List;

import Tree.Node;
import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 07-Apr-2013
 * 
 */
public class ReverseList {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList n1 = new NodeList(5, new NodeList(6, new NodeList(7,
				new NodeList(8,  new NodeList(9, new NodeList(10))))));
		NodeList n2 = new NodeList(4, n1);
		NodeList n3 = new NodeList(3, n2);
		NodeList n4 = new NodeList(2, n3);
		NodeList n5 = new NodeList(1, n4);
		NodeList h = new NodeList(0);
		NodeList n = reverseList(n5, null, h);
		NodeList nRes = reverseEveryAltKList(n5, 3);
		NodeList nResI = reverseEveryKList(n5, 3);
		System.out.println(n);
	}

	public static NodeList reverseList(NodeList l) {
		NodeList current, next, prev = null, head = null;
		while (l != null) {
			next = l.getNext();
			l.setNext(prev);
			prev = l;
			if (head == null) {
				head = prev;
			}
			l = next;
		}
		return head;
	}

	public static NodeList reverseEveryKList(NodeList l, int k) {
		NodeList current = null;
		NodeList tail = null;
		int count = 0;
		while (l != null) {
			NodeList next, prev = null, head = null;
			count = 0;
			while ((l != null) && (count < k)) {
				next = l.getNext();
				l.setNext(prev);
				prev = l;
				if (head == null) {
					head = prev;
				}
				l = next;
				count++;
			}
			if (current != null) {
				current.setNext(prev);
			}
			if (tail == null) {
				tail = prev;
			}
			if (l != null) {
				current = head;
			}

		}
		return tail;
	}

	public static NodeList reverseEveryAltKList(NodeList l, int k) {
		NodeList current = null;
		NodeList tail = null;
		int count = 0;
		while (l != null) {
			NodeList next, prev = null, head = null;
			count = 0;
			while ((l != null) && (count < k)) {
				next = l.getNext();
				l.setNext(prev);
				prev = l;
				if (head == null) {
					head = prev;
				}
				l = next;
				count++;
			}
			while ((l != null) && (count < 2 * k)) {
				head.setNext(l);
				l = l.getNext();
				head = head.getNext();
				count++;
			}
			if (current != null) {
				current.setNext(prev);
				prev = l;
			}
			if (tail == null) {
				tail = prev;
			}
			if (l != null) {
				current = head;
			}

		}
		return tail;
	}

	public static NodeList reverseList(NodeList l, NodeList a, NodeList h) {
		if (l == null) {
			return a;
		}
		a = reverseList(l.getNext(), a, h);
		if (a == null) {
			a = new NodeList(l.getData());
			h = a;
		} else {
			a.setNext(new NodeList(l.getData()));
			a = a.getNext();
		}
		return a;
	}

	public static NodeList reverseChunkIterative(NodeList head, int k) {

		if (head == null)
			return null;

		NodeList first, previous, last;
		first = previous = last = null;

		NodeList current = head;

		while (current != null) {

			NodeList temp = current;
			previous = null;
			NodeList next = null;
			int count = k;

			while (current != null && count > 0) {
				next = current.getNext();
				current.setNext(previous);
				previous = current;
				current = next;
				count--;
			}

			if (first == null)
				first = previous;
			else
				last.setNext(previous);

			last = temp;
		}
		return first;
	}
}
