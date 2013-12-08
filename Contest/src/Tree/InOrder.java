/**
 * 
 */
package Tree;

import java.util.ArrayList;

/**
 * This class is used to
 * 
 * @author Sumit 05-Mar-2013
 * 
 */
public class InOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = new Node(2, null, null);
		Node n2 = new Node(5, null, null);
		Node n3 = new Node(8, n1, n2);
		Node n4 = new Node(20, null, null);
		Node n5 = new Node(10, n3, n4);
		ArrayList<Integer> l = new ArrayList<Integer>();
		inorder(n5, l);
		l = sortArraylist(l);
		Node r = getBST(l, 0, l.size() - 1);
		System.out.println(r);
	}

	public static ArrayList<Integer> inorder(Node root, ArrayList<Integer> l) {
		if (root == null) {
			return l;
		}
		inorder(root.left, l);
		l.add(root.data);
		inorder(root.right, l);
		return l;
	}

	public static ArrayList<Integer> sortArraylist(ArrayList<Integer> l) {
		int swapIndex1 = -1, swapIndex2 = -1, swapVal1 = -1, swapVal2 = -1;
		for (int i = 0, j = 1; j < l.size(); i++, j++) {
			if (l.get(j) < l.get(i)) {
				if (swapVal1 == -1) {
					swapVal1 = l.get(i);
					swapIndex1 = i;
				} else {
					swapIndex2 = j;
					swapVal2 = l.get(j);
				}

			}
		}
		if (swapVal2 == -1) {
			if (l.get(swapIndex1) > l.get(swapIndex1 + 1)) {
				swapIndex2 = swapIndex1 + 1;
			}
		}
		if ((swapIndex1 != -1) && (swapIndex2 != -1)) {
			l.set(swapIndex1, l.get(swapIndex2));
			l.set(swapIndex2, swapVal1);

		}
		return l;

	}

	public static Node getBST(ArrayList<Integer> l, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + ((end - start) / 2);
		Node root = new Node(l.get(mid), null, null);
		root.left = getBST(l, start, mid - 1);
		root.right = getBST(l, mid + 1, end);
		return root;
	}
}
