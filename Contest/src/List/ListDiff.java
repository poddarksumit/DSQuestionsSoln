package List;

import Tree.NodeList;

public class ListDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList l1 = new NodeList(3, new NodeList(2, new NodeList(3)));
		int l1R = getLength(l1);
		NodeList l2 = new NodeList(6, new NodeList(1,new NodeList(8)));
		int l2R = getLength(l2);
		NodeList l1Temp = null;
		if (l1R > l2R) {
			calculate(l1, l2, null, (l1R - l2R));
			System.out.println(l1);
		} else {
			calculate(l2, l1, null, (l2R - l1R));
			System.out.println(l2);
		}
	}

	public static void calculate(NodeList l1, NodeList l2, NodeList back,
			int diff) {
		if (l1 != null) {
			if (l1.getNext() != null) {
				if (diff <= 0) {
					calculate(l1.getNext(),
							(l2.getNext() == null) ? l2 : l2.getNext(), l1,
							diff-1);
				} else {
					calculate(l1.getNext(), l2, l1, diff-1);
				}
			}
			int l1data = l1.getData();
			int l2Data = (diff > 0) ? 0 : l2.getData();
			if ((l1data < l2Data) && (back != null)) {
				l1data += 10;
				back.setData(back.getData() - 1);
			}
			l1.setData(l1data - l2Data);
		}
	}

	public static int getLength(NodeList list) {
		int height = 0;
		while (list != null) {
			height++;
			list = list.getNext();
		}
		return height;
	}
}
