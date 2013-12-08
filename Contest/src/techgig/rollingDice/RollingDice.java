/**
 * 
 */
package techgig.rollingDice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class is used to
 * 
 * @author Sumit 29-Jul-2012
 * 
 */
public class RollingDice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String listOneString = "{ 12, 11, 5, 2, 7, 5, 11}";
		String listTwoString = "{ 5, 12, 5, 7, 11, 2, 11}";

		List<Integer> listOne = convertStringToList(listOneString);
		List<Integer> listTwo = convertStringToList(listTwoString);
		String isLucky = determineLuckyOrUnlucky(listOne, listTwo);
		System.out.println(isLucky);
	}

	public static List<Integer> convertStringToList(String listAsString) {
		List<Integer> list = new ArrayList<Integer>();
		listAsString = listAsString.trim().replace("{", "").replace("}", "")
				.trim();
		String[] stringArray = listAsString.split(",");
		for (int i = 0; i < stringArray.length; i++) {
			list.add(Integer.parseInt(stringArray[i].trim()));
		}

		return list;
	}

	public static String determineLuckyOrUnlucky(List<Integer> listOne,
			List<Integer> listTwo) {
		boolean isLucky = true;
		HashMap<Integer, Integer> listOneMap = getCount(listOne);
		HashMap<Integer, Integer> listTwoMap = getCount(listTwo);
		Set<Integer> mapList = listOneMap.keySet();
		Iterator<Integer> setItr = mapList.iterator();
		while (setItr.hasNext()) {
			int key = setItr.next();
			int valListOne = listOneMap.get(key);
			if (listTwoMap.containsKey(key)) {
				int valListTwo = listTwoMap.get(key);
				if (valListTwo != valListOne) {
					isLucky = false;
				}
			} else {
				isLucky = false;
			}
			if (!isLucky) {
				break;
			}
		}
		return (isLucky) ? "Lucky" : "Unlucky";
	}

	public static HashMap<Integer, Integer> getCount(List<Integer> list) {
		HashMap<Integer, Integer> listMap = new HashMap<Integer, Integer>();
		int count = 0;
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int listVal = itr.next();
			count = 0;
			Iterator<Integer> itrSec = list.iterator();
			while (itrSec.hasNext()) {
				int listSecVal = itrSec.next();
				if (listSecVal == listVal) {
					++count;
				}
			}
			listMap.put(listVal, count);
		}
		return listMap;
	}

}
