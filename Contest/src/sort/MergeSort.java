/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 22-Oct-2013
 * 
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 10, 6, 45, 1, 63 };
		int[] arrayTemp = mergeSort(array, 0, array.length - 1);
		System.out.println(arrayTemp);

	}

	public static int[] mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			sortAndCombine(array, low, mid, high);
		}
		return array;
	}

	public static void sortAndCombine(int[] array, int low, int mid, int high) {
		int[] tempArray = new int[array.length];
		for (int i = low; i <= high; i++) {
			tempArray[i] = array[i];
		}

		int midIn = mid + 1;
		int lowIn = low;
		while ((low <= mid) && (midIn <= high)) {
			if (tempArray[low] <= tempArray[midIn]) {
				array[lowIn] = tempArray[low];
				low++;
			} else {
				array[lowIn] = tempArray[midIn];
				midIn++;
			}
			lowIn++;
		}

		if ((low > mid) && (midIn <= high)) {
			while (midIn <= high) {
				array[lowIn] = tempArray[midIn];
				midIn++;
				lowIn++;
			}
		} else if ((midIn > high) && (low <= mid)) {
			while (low <= mid) {
				array[lowIn] = tempArray[low];
				low++;
				lowIn++;
			}
		}
	}
}
