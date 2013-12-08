/**
 * 
 */
package array;

import java.util.HashMap;

/**
 * This class is used to
 * 
 * @author Sumit 13-Mar-2013
 * 
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 1, 1, 1, 1, 2, 3, 4 };
		System.out.println(getMajorityElement(a));
	}

	public static int getMajorityElement(int[] a) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (hash.containsKey(a[i])) {
				int x = hash.get(a[i]);
				x++;
				hash.put(a[i], x);
				if (x >= a.length / 2) {
					index = a[i];
				}
			} else {
				hash.put(a[i], 1);
			}
		}
		return index;
	}
}
