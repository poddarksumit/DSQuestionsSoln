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
		 int[] array = {-1, 3, -5, 4, 6, -1, 2, -7, 13, -3};
		 //int[] array = { 5, 10, -3, -12, -1 };
		findSubsetArray(array);
	}

	public static void findSubsetArray(int[] array) {
		int sum = 0, maxSum = 0, start = -1, end = 0, inStart = 0;
		int i = 0;
		for (; i < array.length; i++) {
			sum = sum + array[i];
			if (0 < sum + array[i]) {
				if (start == -1) {
					start = i;
				}

			} else if (0 >= sum + array[i]) {
				if (start != -1) {
					inStart = start;
				}
				start = -1;
				sum = 0;
			}
			if (maxSum < sum) {
				inStart = start;
				maxSum = sum;
				end = i;
			}
		}
		System.out.println(maxSum);
		System.out.println(inStart);
		System.out.println(end);
	}
}
