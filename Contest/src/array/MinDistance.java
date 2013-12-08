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
public class MinDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 6, 1, 7, 4, 3, 2, 0, 3 };
		System.out.println(getMinDistance(a, 1, 3));
	}

	public static int getMinDistance(int[] array, int x, int y) {
		int minDist = 0;
		int i = 0;
		int xIndex = -1;
		while (i < array.length) {
			if (array[i] == x) {
				xIndex = i;
			} else if ((array[i] == y) && (xIndex > -1)) {
				if (minDist == 0) {
					minDist = i - xIndex;
				} else {
					minDist = (minDist > (i - xIndex)) ? i - xIndex : minDist;
				}
				xIndex = -1;
			}
			i++;
		}

		if (xIndex > -1) {
			i = 0;
			while ((i < array.length) && (i < xIndex)) {
				if (array[i] == y) {
					minDist = (minDist > (xIndex - i)) ? xIndex - i : minDist;
				}
				i++;
			}
		}

		return minDist;
	}
}
