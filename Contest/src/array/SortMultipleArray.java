/**
 * 
 */
package array;

import java.util.ArrayList;

import Tree.NodeList;

/**
 * This class is used to
 * 
 * @author Sumit 18-Jun-2013
 * 
 */
public class SortMultipleArray {
	public static NodeList head = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1 = { 2, 5, 7, 9, 10, 11 };
		int[] array2 = { 1, 4, 6, 8, 15, 21 };
		ArrayList<NodeList> sortList = new ArrayList<NodeList>();
		NodeList nodeArray1 = arrayToList(array1);
		NodeList nodeArray2 = arrayToList(array2);
		sortList.add(nodeArray1);
		sortList.add(nodeArray2);

	}

	public static NodeList arrayToList(int[] array) {
		NodeList head = null;
		NodeList ll = null;
		for (int i = 0; i < array.length; i++) {
			if (head == null) {
				ll = new NodeList(array[i]);
				head = ll;
			} else {
				NodeList llTemp = new NodeList(array[i]);
				ll.setNext(llTemp);
				ll = ll.getNext();
			}
		}

		return head;
	}

	public static void sortLists(ArrayList<NodeList> arryList) {
		int min = 0;
		NodeList listToModify = null;
		for (int i = 0; i < arryList.size(); i++) {
			NodeList temp = arryList.get(i);
			if (temp != null) {
				if (listToModify == null) {
					listToModify = temp;
					head = listToModify;
				}
				if (i == 0) {
					min = temp.getData();
				} else {
					if (temp.getData() < min) {

						temp = temp.getNext();
						arryList.set(i, temp);
					}
				}
			}

			if (i == arryList.size() - 1) {
				min = 0;
			}
		}

	}
}
