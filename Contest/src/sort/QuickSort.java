/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 13-Mar-2013
 * 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] sort = { 10, 4, 7, 2, 9 };
		sort = quickSort(sort);
		System.out.println(sort);
	}

	public static int[] quickSort(int[] sort) {
		if (sort.length == 1) {
			return sort;
		}
		if (sort.length == 2) {
			if (sort[0] > sort[1]) {
				int mid = sort[0];
				sort[0] = sort[1];
				sort[1] = mid;
				return sort;
			}
		}
		int midd = sort[sort.length / 2];
		int[] small = new int[sort.length];
		int[] large = new int[sort.length];
		int smallCount = 0, largeCount = 0;
		for (int i = 0; i < sort.length; i++) {
			if (sort[i] < midd) {
				small[smallCount] = sort[i];
				smallCount++;
			} else {
				large[largeCount] = sort[i];
				largeCount++;
			}
		}
		small = quickSort(small);
		large = quickSort(large);
		for (int j = 0; j < large.length; j++) {
			small[small.length] = large[j];
		}
		return sort;
	}
}
