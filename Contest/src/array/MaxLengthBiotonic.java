/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 03-Nov-2013
 * 
 */
public class MaxLengthBiotonic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 1, 11, 2, 10, 4, 5, 2, 1 };
		maxLengthBiotonicSubarray(array);
	}

	public static void maxLengthBiotonicSubarray(int[] array) {
		int startIndex = -1, startIndexTemp = -1, k = -1, max = -1, maxTemp = -1, end = -1;
		int kTemp = -1;
		boolean consLastSection = false;
		int i = 1;
		for (; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				consLastSection = true;
				if ((startIndexTemp == -1) && (k == -1)) {
					startIndexTemp = i - 1;
				} else if (k > -1) {
					maxTemp = i - startIndexTemp;
					if (maxTemp > max) {
						max = maxTemp;
						startIndex = startIndexTemp;
						end = i;
						kTemp = k;
						k = -1;
						startIndexTemp = i;
					}
				}
			} else if (startIndexTemp > -1) {
				if (k == -1) {
					k = i - 1;
				}
			}
		}
		if (consLastSection && (k > -1)) {
			maxTemp = i - startIndexTemp;
			if (maxTemp > max) {
				max = maxTemp;
				startIndex = startIndexTemp;
				end = i;
				kTemp = k;
				startIndexTemp = -1;
			}
		} else if (max == -1) {
			startIndex = 0;
			end = array.length + 1;
			max = array.length;
		}
		System.out.println(" k = " + kTemp + ". Start Index = " + startIndex
				+ ". End Index = " + (end - 1) + ". Max Length = " + max);

	}
}
