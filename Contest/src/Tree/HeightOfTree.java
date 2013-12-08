/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 29-Aug-2013
 * 
 */
public class HeightOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(8, null, null);
		Node n3 = new Node(5, n1, n2);

		Node n111 = new Node(16, null, null);
		Node n211 = new Node(22, null, null);

		Node n11 = new Node(21, n111, n211);
		Node n21 = new Node(25, null, null);

		Node n4 = new Node(23, n11, n21);

		// Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);

		System.out.println(getHeight(n5, 0, 0));
		System.out.println(getHeight1Cnd(n5, 0, 0));

	}

	public static int getHeight(Node x, int hImm, int hMax) {
		if (x == null) {
			return hImm;
		}
		hImm += 1;

		int yImm = getHeight(x.left, hImm, hMax);
		if (hMax < yImm) {
			hMax = yImm;
		}
		int zImm = getHeight(x.right, hImm, hMax);
		if (hMax < zImm) {
			hMax = zImm;
		}
		return hMax;

	}

	public static int getHeight1Cnd(Node x, int hImm, int hMax) {
		if (x == null) {
			return hImm;
		}
		hImm += 1;

		int yImm = getHeight(x.left, hImm, hMax);
		int zImm = getHeight(x.right, hImm, hMax);
		if (yImm < zImm) {
			hMax = zImm;
		} else {
			hMax = yImm;
		}
		return hMax;

	}

}
