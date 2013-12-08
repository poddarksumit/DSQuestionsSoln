/**
 * 
 */
package Test;

/**
 * This class is used to
 * 
 * @author Sumit 11-Feb-2013
 * 
 */
public class FindTriplet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node l1 = new Node(29, null);
		Node l2 = new Node(6, l1);
		Node n = new Node(12, l2);

		// Node l3 = new Node(20, null);
		Node l4 = new Node(5, null);
		Node m = new Node(23, l4);

		Node l5 = new Node(72, null);
		Node l6 = new Node(20, l5);
		Node r = new Node(90, l6);

		checkSum(n, m, r, 101);

	}

	public static void checkSum(Node n, Node m, Node r, int no) {
		boolean[] bool = new boolean[256];
		int sum = 0, diff = 0;
		while (r != null) {
			bool[r.data] = true;
			r = r.next;
		}

		while ((n != null) || (m != null)) {
			sum = 0;
			if (n != null) {
				sum += n.data;
			}
			if (m != null) {
				sum += m.data;
			}
			diff = no - sum;
			if ((diff > 0) && (bool[diff])) {
				if (n != null) {
					System.out.println(n.data);
				}
				if (m != null) {
					System.out.println(m.data);
				}

				System.out.println(diff);
			}
			if (n != null) {
				n = n.next;
			}
			if (m != null) {
				m = m.next;
			}

		}
	}
}

class Node {
	int data;
	Node next;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

}
