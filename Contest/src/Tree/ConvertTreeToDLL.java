package Tree;

public class ConvertTreeToDLL {
	static NodeList head = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, new Node(6, null, null), new Node(7, null, null));
		Node n2 = new Node(3, new Node(10, null, null),
				new Node(25, null, null));
		Node n3 = new Node(8, null, null);
		NodeList list = null;
		list = convert(n3, list);
		System.out.println(head.data);
	}

	public static NodeList convert(Node root, NodeList list) {
		if (root == null) {
			return list;
		}
		list = convert(root.left, list);
		NodeList listTemp = new NodeList(root.data);
		if ((list != null) && (root != null)) {

			list.next = listTemp;
			listTemp.prev = list;
			list = list.next;
		} else {
			if (head == null) {
				head = listTemp;
			}
			list = listTemp;
		}
		list = convert(root.right, list);
		return list;
	}
}
