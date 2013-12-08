/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 07-Apr-2013
 * 
 */
public class ReverseArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 1, 9, 0, 8, 5, 10, 19 };
		System.out.println(reverseArray(array));
	}

	public static int[] reverseArray(int array[]) {
		if (array != null) {
			int j = array.length - 1;
			for (int i = 0; i < array.length / 2; i++) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j--;
			}
		}
		return array;
	}
}
