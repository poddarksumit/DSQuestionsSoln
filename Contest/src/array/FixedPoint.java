/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 28-Apr-2013
 * 
 */
public class FixedPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 0, 1, 2, 3, 4 };
		System.out.println(fixedPoint(a, 0, a.length - 1));
	}

	public static int fixedPoint(int[] array, int start, int end) {
		int fixedPoint = -1;
		if (start < end) {
			int mid = start + (end - start) / 2;
			if (array[mid] == mid) {
				return mid;
			} else {
				fixedPoint = fixedPoint(array, start, mid - 1);
				if (fixedPoint == -1) {
					fixedPoint = fixedPoint(array, mid + 1, end);
				}
			}
		}
		return fixedPoint;
	}
}
