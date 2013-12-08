/**
 * 
 */
package array;

import sort.QuickSort2;

/**
 * This class is used to
 * 
 * @author Sumit 20-Apr-2013
 * 
 */
public class ArraySubset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = { 11, 1, 13, 21, 3, 7 };
		int arr2[] = { 11, 3, 7, 1 };
		System.out.println(isSubset(arr2, arr1));
	}

	public static boolean isSubset(int[] a, int[] b) {
		boolean isValidSubset = true;

		a = QuickSort2.sort(a, 0, a.length - 1);
		b = QuickSort2.sort(b, 0, b.length - 1);
		int aIndex = 0, bIndex = 0;
		while (isValidSubset && (aIndex < a.length) && (bIndex < b.length)) {
			if (a[aIndex] == b[bIndex]) {
				aIndex++;
			} else if (b[bIndex] > a[aIndex]) {
				isValidSubset = false;
			}
			bIndex++;
		}

		return isValidSubset;
	}
}
