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
public class SearchIn2DArry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		searchIn2DArry(array, 17);
	}

	public static void searchIn2DArry(int[][] array, int elment) {
		int row = 0, col = array.length - 1;

		for (; col >= 0; col--) {
			if (array[0][col] < elment) {
				break;
			}
		}
		if (array[0][col] != elment) {
			for (; row < array.length; row++) {
				if (array[row][col] == elment) {
					break;
				}
			}
		}

		if ((row < array.length) && (col < array.length)
				&& (array[row][col] == elment)) {
			System.out.println("Row : " + row);
			System.out.println("col : " + col);
		}
	}
}
