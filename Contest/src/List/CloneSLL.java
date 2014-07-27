package List;

import Tree.NodeList;

public class CloneSLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeList root = new NodeList(1, new NodeList(2, new NodeList(3,
				new NodeList(4))));
		NodeList rootTemp = cloneLL(root);
		System.out.println(rootTemp);
	}

	public static NodeList cloneLL(NodeList list) {
		NodeList listTemp = new NodeList(list.getData()), clone = list;
		NodeList headClone = clone;
		while (list != null) {
			clone.setRandom(listTemp);
			listTemp = new NodeList(list.getData());
			clone = clone.getNext();
			list = list.getNext();
		}
		return headClone;
	}
}
