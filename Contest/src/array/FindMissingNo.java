/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 19-Apr-2013
 * 
 */
public class FindMissingNo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 6, 9, 3, 2, 4, 1, 7, 8 };
		int[] b = getDuplicateNumber(a);
		if ((b != null) && (b.length > 0)) {
			getMissingNumber(b);
		}
		int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9 };
	}

	public static int[] getDuplicateNumber(int[] a) {
		int[] b = null;
		if ((a != null) && (a.length > 0)) {
			b = new int[a.length + 1];
			for (int i = 0; i < a.length; i++) {
				if (b[a[i]] != 0) {
					System.out.println("The duplicate is " + b[a[i]]);
				}
				b[a[i]] = a[i];
			}
		}
		return b;
	}

	public static void getMissingNumber(int[] a) {
		boolean nullFound = false;
		int i = 1;
		while (!nullFound && i < a.length) {
			if (a[i] == 0) {
				System.out.println("Missing number is " + i);
				nullFound = false;
			}
			i++;
		}
	}
}
