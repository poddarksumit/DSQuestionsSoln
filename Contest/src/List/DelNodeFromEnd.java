package List;

import Tree.NodeList;

public class DelNodeFromEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList list1 = new NodeList(9, new NodeList(9, new NodeList(3,
				new NodeList(4, new NodeList(5)))));
		int l = deleteNode(list1, 1, 0, null);
		System.out.println(l);
	}

	public static int deleteNode(NodeList list, int k, int length, NodeList prev) {
		if (list == null) {
			return 0;
		}
		length = deleteNode(list.getNext(), k, length, list);
		if (k == length + 1) {
			if (prev != null) {
				prev.setNext((list == null) ? null : list.getNext());
			} else {
				list = list.getNext();
			}
			return -2;
		}
		return (length == -2) ? length : length + 1;
	}
}
