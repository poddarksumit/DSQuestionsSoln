/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 19-Nov-2013
 * 
 */
public class SortedSeqOfSize3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 3, 10, 5, 1, 11, 4, 3, 9, 12 };
		findSeqOfSortedNumber(array, 4);

	}

	public static void findSeqOfSortedNumber(int[] array, int n) {
		int[] arrayTemp = new int[n];
		for (int i = 0; i < n; i++) {
			arrayTemp[i] = -1;
		}
		int a1 = -1, a2 = -1, a3 = -1, maxVal = -1;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] < array[i]) {
				if ((maxVal > -1) && (maxVal < array[i])) {
					if (arrayTemp[2] == -1) {
						arrayTemp[2] = array[i];
					} else {
						arrayTemp[3] = array[i];
						break;
					}
				} else {
					// a1 = array[i - 1];
					// a2 = array[i];
					arrayTemp[0] = array[i - 1];
					arrayTemp[1] = array[i];
					maxVal = arrayTemp[1];
				}
			} else if ((maxVal > -1) && (maxVal < array[i])) {
				if (arrayTemp[2] == -1) {
					arrayTemp[2] = array[i];
				} else {
					arrayTemp[3] = array[i];
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arrayTemp[i]);
		}
	}
}
