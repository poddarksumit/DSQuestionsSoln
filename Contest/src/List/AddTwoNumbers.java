package List;

import Tree.NodeList;

public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList list1 = new NodeList(9, new NodeList(9, new NodeList(3,
				new NodeList(4, new NodeList(5)))));
		NodeList list2 = new NodeList(8, new NodeList(9, new NodeList(1,
				new NodeList(5, new NodeList(7, null)))));
		int lngth1 = getLength(list1);
		int lngth2 = getLength(list2);
		int diff = (lngth1 > lngth2) ? lngth1 - lngth2 : lngth2 - lngth1;
		NodeList res = getSum(list1, list2, diff);
		System.out.println(res.getData());
	}

	public static NodeList getSum(NodeList list1, NodeList list2, int diff) {
		if (list1 == null) {
			return new NodeList(0);
		}
		NodeList res = getSum(list1.getNext(),
				(diff > 0) ? list2 : list2.getNext(), diff - 1);
		int data = list1.getData() + ((diff > 0) ? 0 : list2.getData())
				+ res.getData();
		if (data < 10) {
			list1.setData(data);
			res = new NodeList(0);
		} else {
			list1.setData(data - 10);

			res = new NodeList(1);
		}
		return res;
	}

	public static int getLength(NodeList list) {
		int length = 0;
		while (list != null) {
			if ((list.getNext() != null) && (list.getNext().getNext() != null)) {
				length += 2;
				list = list.getNext().getNext();
			} else {
				length += 1;
				list = list.getNext();
			}
		}
		return length;
	}
}
