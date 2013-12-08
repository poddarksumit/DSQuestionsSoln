/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 01-May-2013
 * 
 */
public class MaxElementAscDec {

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4, 5, 3, 3, 2, 2, 1, 1 };
		System.out.println(maxAscDesc(a, 0, a.length - 1, -1));
	}

	/**
	 * @param args
	 */

	public static int maxAscDesc(int[] array, int start, int end, int max) {
		if (start <= end) {
			int mid = start + (end - start) / 2;
			if (max < array[mid]) {
				max = array[mid];
			}
			max = maxAscDesc(array, start, mid - 1, max);
			max = maxAscDesc(array, mid + 1, end, max);
		}
		return max;
	}
}
