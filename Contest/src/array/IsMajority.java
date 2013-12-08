/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 13-Oct-2013
 * 
 */
public class IsMajority {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 3, 3, 3, 3, 4, 5, 6 };
		System.out.println("Maj : "
				+ isMajority(array, 3, 0, array.length - 1, 0));

	}

	public static int isMajority(int[] array, int element, int low, int high,
			int count) {
		if (low <= high) {

			int mid = low + (high - low) / 2;
			System.out.println(array[mid]);
			if (array[mid] == element) {
				count += 1;
				if (ifMidInRange(mid, low, high) && (array[mid - 1] == element)) {
					count = isMajority(array, element, low, mid - 1, count);
				}
				if (ifMidInRange(mid, low, high) && (array[mid + 1] == element)) {
					count = isMajority(array, element, mid + 1, high, count);
				}
			} else if (array[mid] < element) {
				count = isMajority(array, element, mid + 1, high, count);

			} else if (array[mid] > element) {
				count = isMajority(array, element, low, mid - 1, count);
			}
		}
		return count;
	}

	public static boolean ifMidInRange(int mid, int low, int high) {

		if (low < mid && mid < high) {
			return true;
		}
		return false;

	}
}
