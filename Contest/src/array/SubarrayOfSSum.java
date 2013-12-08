/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 22-Jun-2013
 * 
 */
public class SubarrayOfSSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 4, 20, 3, 10, 5 };
		findSubArray(array, 33);
	}

	public static void findSubArray(int[] a, int x) {
		int start = 0, end = 0;
		int sum = 0;
		while ((sum <= x) && (end < a.length)) {
			sum += a[end];
			end++;
		}
		end -= 1;
		if (sum > x) {
			while ((sum > x) && (start < end)) {
				sum -= a[start];
				start++;

			}
		} else {
			System.out.println("Array not sufficient");
		}
		System.out.println(start + " : " + end);
	}

}
