/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 07-Mar-2013
 * 
 */
public class TreeToList {

	static int height = 0;
	static NodeList y = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);

		Node n111 = new Node(16, null, null);
		Node n211 = new Node(17, null, null);

		Node n11 = new Node(21, n111, n211);
		Node n21 = new Node(25, null, null);

		Node n4 = new Node(20, n11, n21);

		// Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);
		NodeList list = null;
		list = getCircularList(n5);
		System.out.println(list);
		NodeList z = null;
		NodeList listt = getList(n5, z);
		System.out.println(y);
		getHeight(n5, 0);
		System.out.println(height);
		intValTest(1);
		System.out.println();

	}

	public static NodeList getCircularList(Node r) {
		if (r == null) {
			return null;
		}
		NodeList l = getCircularList(r.left);
		NodeList a = new NodeList(r.data);
		if (l == null) {
			l = a;
		} else {
			l = insertToHead(a, l);
		}
		NodeList c = getCircularList(r.right);
		if (c != null) {
			l = insertToHead(c, l);
		}
		return l;
	}

	public static NodeList insertToHead(NodeList c, NodeList l) {
		NodeList lTemp = l;
		while (l.next != null) {
			l = l.next;
		}
		l.next = c;
		return lTemp;
	}

	public static int getHeight(Node r, int sum) {
		if (r == null) {
			return sum;
		}
		sum += 1;
		sum = getHeight(r.left, sum);
		if (sum > height) {
			height = sum;
		}
		sum = getHeight(r.right, sum);
		if (sum > height) {
			height = sum;
		}
		sum -= 1;
		return sum;
	}

	public static NodeList getList(Node r, NodeList z) {
		if (r == null) {
			return z;
		}
		z = getList(r.left, z);
		NodeList a = new NodeList(r.data);
		if (z != null) {
			z.next = a;
			z = z.next;
		} else {
			z = a;
			y = z;
		}
		z = getList(r.right, z);
		return z;
	}

	public static void intValTest(int z) {
		System.out.println("1 : " + z);
		int a = 15;
		z = a;
		System.out.println("2 : " + a);
		z = z + 10;
		System.out.println("3 : " + z);
		System.out.println("4 : " + a);
		a = z;
		a = a + 10;
		System.out.println("5 : " + z);
		System.out.println("6 : " + a);
	}
}
