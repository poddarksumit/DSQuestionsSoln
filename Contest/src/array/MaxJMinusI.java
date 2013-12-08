/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 20-Apr-2013
 * 
 */
public class MaxJMinusI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 18, 7, 6, 5, 10, 4, 3, 2, 1 };
		System.out.println(getMaxDiff(a));
	}

	public static int getMaxDiff(int[] a) {
		int maxDiff = -1;
		int i = 0, j = a.length - 1;
		while ((i <= j) && (maxDiff == -1)) {
			if (a[j] > a[i]) {
				while ((i >= 0) && (a[j] > a[i])) {
					i--;
				}
				if (i == -1) {
					i = 0;
				}
				if ((a[j] < a[i]) && (a[j] > a[i + 1])) {
					i++;
				}
				maxDiff = j - i;
			} else {
				j--;
				if (a[j] > a[i]) {
					while ((i >= 0) && (a[j] > a[i])) {
						i--;
					}
					if (i == -1) {
						i = 0;
					}
					if ((a[j] < a[i]) && (a[j] > a[i + 1])) {
						i++;
					}
					maxDiff = j - i;
				}
			}
			i++;
		}
		return maxDiff;

	}

}
