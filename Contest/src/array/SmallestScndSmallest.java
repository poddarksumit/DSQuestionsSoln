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
public class SmallestScndSmallest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArray = { 10, 15, 13, 8, 1, 6, 5, 11, 18 };
		getSmallestAndScndSmallest(intArray);
		int[] intArray1 = { -10, -15, -13, -8, -1, -6, -5, -11, -18 };
		getSmallestAndScndSmallest(intArray1);

	}

	public static void getSmallestAndScndSmallest(int[] array) {
		int smallest = Integer.MAX_VALUE;
		int scndSmallest = Integer.MAX_VALUE;

		for (int i = 0; i < array.length; i++) {
			if (smallest > array[i]) {
				scndSmallest = smallest;
				smallest = array[i];
			} else if ((smallest < array[i]) && (scndSmallest > array[i])) {
				scndSmallest = array[i];
			}
		}

		System.out.println(smallest);
		System.out.println(scndSmallest);
	}

}
