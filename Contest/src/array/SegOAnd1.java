/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 03-Apr-2013
 * 
 */
public class SegOAnd1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 4, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		a = segArray(a);
		System.out.println(a);
		System.out.println(a[Math.abs(a[0])]);
	}

	public static int[] segArray(int[] array) {
		int end = -1, temp = 0, i = 0;
		while ((i + 1) < array.length) {
			if (array[i] > array[i + 1]) {
				if (end == -1) {
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					end = i + 1;
				} else {
					temp = array[end];
					array[end] = array[i + 1];
					array[i + 1] = temp;
					end++;
				}
			}
			i++;
		}
		return array;
	}
}
