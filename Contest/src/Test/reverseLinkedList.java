/**
 * 
 */
package Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class is used to
 * 
 * @author Sumit 20-Jan-2013
 * 
 */
public class reverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> intval = new LinkedList<Integer>();
		intval.add(1);
		intval.add(2);
		intval.add(3);
		intval.add(4);
		intval.add(5);
		intval.add(6);
		intval.add(3);
		intval.add(8);
		intval.add(9);
		// intval.add(10);
		String s = "";
		int[] intval1 = { 1, 78, 32, 70, 1, 5, 7, 91 };
		setImpl(intval1);
		System.out.println("Hello");
		System.out.println(countA("abcbaaaiutsa", 'a'));
	}

	private static LinkedList<Integer> reverseIt(LinkedList<Integer> intval) {
		LinkedList<Integer> intvalTemp = new LinkedList<Integer>();
		int size = intval.size();
		for (int i = 0; i < size - 1; i++) {
			int val1 = intval.get(i);
			int lastPos = size - 1 - i;
			int val2 = intval.get(lastPos);
			if (i == lastPos) {
				break;
			} else {
				intval.add(i, val2);
				intval.add(lastPos, val1);
			}
		}

		return intval;

	}

	private static int getMiddleObject(LinkedList<Integer> intval) {
		int i = 0, n = 0;
		try {
			while (intval.get(n) != null) {
				i++;
				n += 2;
			}
		} catch (IndexOutOfBoundsException exception) {
			// System.err.println("Error");
		} catch (Exception exception) {
			// TODO: handle exception
		}
		return intval.get(i - 1);

	}

	private static void setImpl(int[] in) {
		Set<Integer> set = new TreeSet<Integer>();
		int n = 0;
		try {
			while (n < in.length) {
				set.add(in[n]);
			}
		} catch (IndexOutOfBoundsException exception) {
			System.err.println("Error");
		}
		System.out.println("size : " + set.size());
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static int countA(String s, char a) {
		int i = 0;
		if (s.length() > 0) {
			countA(s.substring(1, s.length()), a);
		}
		if (a == s.charAt(0)) {
			i++;
		}
		return i;
	}
}
