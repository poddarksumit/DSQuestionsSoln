package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumDiffEvenOddLvl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(5, new Node(2, new Node(1), new Node(4,
				new Node(3), null)), new Node(6, null, new Node(8, new Node(7),
				new Node(9))));
		System.out.println(calculateDiff(root));
	}

	public static int calculateDiff(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		queue.add(null);
		int sumE = 0, sum = 0, sumO = root.data, lvel = 2;
		while (!queue.isEmpty()) {
			Node x = queue.poll();
			if (x == null) {
				if (lvel % 2 == 0) {
					sumE += sum;
				} else {
					sumO += sum;
				}
				lvel++;
				sum = 0;
				if (!queue.isEmpty())
					queue.add(null);
			} else {
				if (x.left != null) {
					sum += x.left.data;
					queue.add(x.left);
				}
				if (x.right != null) {
					sum += x.right.data;
					queue.add(x.right);
				}
			}

		}
		System.out.println("sumO : " + sumO);
		System.out.println("sumE : " + sumE);
		return sumO - sumE;
	}
}
