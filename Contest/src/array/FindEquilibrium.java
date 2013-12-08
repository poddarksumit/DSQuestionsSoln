/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 21-Apr-2013
 * 
 */
public class FindEquilibrium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 1, 1, 0, 4 };
		System.out.println(getEquilibruimIndex(a));
	}

	public static int getEquilibruimIndex(int[] a) {
		int sum = 0, index = 0, lSum = 0;
		boolean isFound = false;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		while ((!isFound) && (index < a.length)) {
			sum -= a[index];
			if (sum == lSum) {
				isFound = true;
			} else {
				lSum += a[index];
				index++;
			}
		}
		return index;
	}
}
