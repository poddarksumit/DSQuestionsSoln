/**
 * 
 */
package techgig.tomtom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This class is used to
 * 
 * @author Sumit 27-Sep-2012
 * 
 */
public class TomTom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String listIdenticalCheck = "no";
		String R1 = "{C,A,P,G,K,F,J,L,D,H,K,D,M,J}";
		// String R2 = "{K,D,M,J,C,A,P,G,K,F,J,L,D,H}";
		String R2 = "{P,GK,D,M,J,C,A,A,F,J,L,D,H}";
		String R3 = "{J,M,D,K,H,D,L,J,F,K,G,P,A,C}";
		List<String> listR1 = stringToArrayList(R3);
		List<String> listR2 = stringToArrayList(R2);
		if (listR1.size() == listR2.size()) {

			listIdenticalCheck = implementIdenticalCheckProcess(listR1, listR2);
		}
		System.out.println(listIdenticalCheck);
	}

	public static List<String> stringToArrayList(String list) {
		List<String> listAsArrayList = new ArrayList<String>();
		list = list.replace("{", "");
		list = list.replace("}", "");
		String[] omittedBracStringSplit = list.split(",");
		for (String str : omittedBracStringSplit) {
			listAsArrayList.add(str);
		}
		return listAsArrayList;
	}

	public static ArrayList<Integer> getOccurenceForFirstElement(
			List<String> list, String str) {
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

	public static String implementIdenticalCheckProcess(List<String> listR1,
			List<String> listR2) {
		boolean isListSame = false;
		List<String> listR1RevOrder;
		isListSame = implementIdenticalCheck(listR1, listR2);
		if (!isListSame) {
			listR1RevOrder = listR1;
			Collections.reverse(listR1RevOrder);
			isListSame = implementIdenticalCheck(listR1RevOrder, listR2);

		}
		return (isListSame) ? "yes" : "no";

	}

	public static boolean implementIdenticalCheck(List<String> listR1,
			List<String> listR2) {
		boolean isListSame = false;
		boolean isFirstHalfValid;
		List<String> listR1Temp, listR2Temp, listR1RevOrder;
		ArrayList<Integer> occurenceOfFirstElement = getOccurenceForFirstElement(
				listR1, listR2.get(0));
		Iterator<Integer> itr = occurenceOfFirstElement.iterator();
		while ((itr.hasNext()) && (!isListSame)) {
			Integer itrVal = itr.next();
			isFirstHalfValid = iterateBothList(listR1, listR2, itrVal);
			System.out.println(isFirstHalfValid);
			if ((itrVal != 0) && (isFirstHalfValid)) {
				listR1Temp = listR1.subList(0, itrVal);
				listR2Temp = listR2.subList(listR1.size() - itrVal,
						listR2.size());
				itrVal = 0;
				isFirstHalfValid = iterateBothList(listR1Temp, listR2Temp,
						itrVal);
				System.out.println(isFirstHalfValid);
			}

			isListSame = isFirstHalfValid;
		}

		return isListSame;

	}

	private static boolean iterateBothList(List<String> listR1,
			List<String> listR2, Integer itrVal) {
		boolean isFirstHalfValid = true;
		int indexOfListR2 = 0;
		for (int index = itrVal; index < listR1.size(); index++) {
			if (!listR1.get(index).equalsIgnoreCase(listR2.get(indexOfListR2))) {
				isFirstHalfValid = false;
				break;
			} else {
				indexOfListR2++;
			}
		}
		return isFirstHalfValid;
	}

	public static boolean checkOtherDirectionWise(List<String> listR1RevOrder,
			List<String> listR2, Integer itrVal) {
		boolean isFirstHalfValid = false;
		isFirstHalfValid = iterateBothList(listR1RevOrder, listR2, itrVal);
		System.out.println("checkOtherDirectionWise : " + isFirstHalfValid);
		if ((itrVal != 0) && (isFirstHalfValid)) {
			List<String> listR1Temp = listR1RevOrder.subList(0, itrVal);
			List<String> listR2Temp = listR2.subList(listR1RevOrder.size()
					- itrVal, listR2.size());
			itrVal = 0;
			isFirstHalfValid = iterateBothList(listR1Temp, listR2Temp, itrVal);
			System.out.println("checkOtherDirectionWise : " + isFirstHalfValid);
		}
		return isFirstHalfValid;
	}
}
