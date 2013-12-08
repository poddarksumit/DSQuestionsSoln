/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 16-Oct-2013
 * 
 */
public class NGE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 5, 2, 3, 1, 4 };
		System.out.println(nge(array, -1, 0));

	}

	public static int nge(int[] array, int lastIndex, int index) {
		if (index == array.length) {
			return -1;
		}
		int y = nge(array, array[index], index + 1);

		if (array[index] < y) {
			System.out.println(array[index] + " : " + y);
		} else {
			System.out.println(array[index] + " : " + -1);
		}

		if (lastIndex < array[index]) {
			return array[index];
		} else {
			return y;
		}

	}
}
