package Tree;

public class LeavesToDL {
	static NodeList head = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4, new Node(8, new Node(1,
				null, null), null), new Node(9, new Node(13, null, null),
				new Node(14, new Node(15, null, null), null))), new Node(5,
				new Node(12, null, null), null)), new Node(3, new Node(6, null,
				null), new Node(7,
				new Node(10, null, new Node(11, null, null)), null)));
		NodeList list = null;
		process(root, list);
		System.out.println(head);
	}

	public static NodeList process(Node node, NodeList list) {
		if (node != null) {
			if ((node.left == null) && (node.right == null)) {
				NodeList l = new NodeList(node.data);
				if ((head == null) && (list == null)) {
					list = l;
					head = list;
				} else {
					l.prev = list;
					list = l;
					list = list.next;
				}
			}
			list = process(node.left, list);
			list = process(node.right, list);
		}
		return list;
	}
}
