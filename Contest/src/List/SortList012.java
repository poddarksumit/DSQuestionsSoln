package List;

import com.sun.xml.internal.bind.v2.model.core.Ref;

import Tree.NodeList;

public class SortList012 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList list = new NodeList(0, new NodeList(2, new NodeList(1,
				new NodeList(0, new NodeList(2)))));
		NodeList hed = sortList(list);
		System.out.println(hed.getData());
	}

	public static NodeList sortList(NodeList list) {
		NodeList head = list;
		int count0 = 0, count1 = 0, count2 = 0;
		while (list != null) {
			if (list.getData() == 0) {
				count0 += 1;
			} else if (list.getData() == 1) {
				count1 += 1;
			} else if (list.getData() == 2) {
				count2 += 1;
			} else {
				list = null;
				System.out.println("Not a good input");
			}
			list = new NodeList(10);
			list = list.getNext();
		}
		return head;
	}
}
