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
public class NumberOfOccurence {
	static int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 1, 3, 3, 3, 3, 7, 7, 7, 11, 11, 12 };
		getOccurence(a, 11, 0, a.length - 1);
		System.out.println(count);
	}

	public static void getOccurence(int[] a, int x, int low, int high) {
		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == x) {
				count++;
			}
			if (a[mid] >= x) {
				getOccurence(a, x, low, mid - 1);
			}
			getOccurence(a, x, mid + 1, high);
		}
	}
}
