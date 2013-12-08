/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 21-Apr-2013
 * 
 */
public class SmallestMissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getSmallestNo(int[] array, int low, int high) {
		if (low > high) {
			return high + 1;
		}
		if (array[low] != low) {
			return low;
		}
		int mid = low + (high - low) / 2;
		if (array[mid] > mid) {
			getSmallestNo(array, low, mid);
		} else {
			getSmallestNo(array, mid + 1, high);
		}
		return;
	}
}
