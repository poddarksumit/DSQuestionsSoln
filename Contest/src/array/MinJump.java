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
public class MinJump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 2, 3, 4, 1, 1, 1 };
		System.out.println(findMinJump(array));

	}

	public static int findMinJump(int[] array) {
		int count = 0, start = 0, end = array[0], max = 0, nxtSrt = 0;
		for (; start < end;) {
			int i = start + 1;
			if (i < array.length) {
				int val = array[i] + i;
				if (val == array.length) {
					count++;
					break;
				} else {
					if ((val <= array.length) && (max < val)) {

						max = val;
						nxtSrt = i;
					}
					start++;
					if (start >= end - 1) {
						start = nxtSrt;
						end = ((start + array[start] + 1) > array.length) ? array.length
								: start + array[start] + 1;
						max = 0;
						count++;
					}
				}
			} else if (i == array.length) {
				break;
			}

		}
		return count;
	}
}
