/**
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This class is used to
 * 
 * @author Sumit 17-Jun-2013
 * 
 */
public class FindSumOfNodes {

	public static int height = -1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n = new Node(1, null, null);
		Node n31 = new Node(7, null, null);
		Node n32 = new Node(9, null, null);

		Node n1 = new Node(8, n31, n32);
		Node n2 = new Node(5, n, n1);

		Node n3 = new Node(13, null, null);

		Node n4 = new Node(20, null, null);
		Node n5 = new Node(15, n3, n4);

		Node n6 = new Node(10, n2, n5);

		getHeight(n6, 1);
		System.out.println(height);
		ArrayList<Integer> l = InOrder.inorder(n6, new ArrayList<Integer>());
		System.out.println(countSumNode(l, 18));
	}

	public static Stack<Node> createNrmlStack(Node a, Stack<Node> s) {
		if (a == null) {
			return s;
		}
		createNrmlStack(a.left, s);
		s.push(a);
		createNrmlStack(a.right, s);
		s.push(a);
		return s;
	}

	public static Stack<Node> createRevStack(Node a, Stack<Node> s) {
		if (a == null) {
			return s;
		}
		createRevStack(a.right, s);
		s.push(a);
		createRevStack(a.left, s);
		s.push(a);
		return s;
	}

	public static void getHeight(Node a, int index) {
		if (a.left != null) {
			getHeight(a.left, index + 1);
		}
		if (height < index) {
			height = index;
		}
		if (a.right != null) {
			getHeight(a.right, index + 1);
		}

	}

	public static int countSumNode(ArrayList<Integer> l, int k) {
		int startIndex = 0, endIndex = l.size() - 1;
		int count = 0;
		while (startIndex < endIndex) {
			if (l.get(startIndex) + l.get(endIndex) == k) {
				count += 1;
				endIndex -= 1;
			} else if (l.get(startIndex) + l.get(endIndex) > k) {
				endIndex -= 1;
			} else {
				startIndex += 1;
			}
		}
		return count;
	}
}
