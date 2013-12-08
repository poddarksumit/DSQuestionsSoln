/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 23-Jul-2013
 * 
 */
public class KadanneTheorm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 2, 8, -2, 10, 3, -2, -1 };
		findSubsetArray(array);
	}

	public static void findSubsetArray(int[] array) {
		int sum = 0, maxSum = 0, start = 0, end = 0, inStart = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum < (sum += array[i])) {
				sum += array[i];
				if (start == -1) {
					start = i;
				}
			} else {
				if (sum > maxSum) {
					maxSum = sum;
					end = i - 1;
					sum = 0;
					inStart = start;
					start = -1;
				}
			}
		}
		System.out.println(inStart);
		System.out.println(end);
	}
}
