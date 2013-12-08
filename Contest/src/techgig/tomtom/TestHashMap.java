/**
 * 
 */
package techgig.tomtom;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class is used to
 * 
 * @author Sumit 24-Sep-2012
 * 
 */
public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> list = new ArrayList<String>();
		list.add("C");
		list.add("A");
		list.add("P");
		list.add("G");
		list.add("A");
		list.add("F");
		list.add("J");
		list.add("L");
		list.add("D");
		list.add("H");
		list.add("K");
		list.add("D");
		list.add("M");
		list.add("J");
		ArrayList<Integer> num = getOccurence(list, "A");
		System.out.println(num);
	}

	public static ArrayList<Integer> getOccurence(ArrayList<String> list,
			String str) {
		int num = 0;
		ArrayList<Integer> listTemp = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			String strTemp = list.get(i);
			if (strTemp.equals(str)) {
				listTemp.add(i);
			}
		}
		return listTemp;

	}

	public static void getResult(ArrayList<Integer> num,
			ArrayList<Integer> listR1, ArrayList<Integer> listR2) {
		boolean isSplit = false;
		boolean isPatternMatchedTemp = false;
		Iterator<Integer> itr = num.iterator();
		while ((itr.hasNext()) && (!isSplit)) {
			Integer i = itr.next();
			for (int index = i; index < listR1.size(); index++) {

			}

		}
	}
}
