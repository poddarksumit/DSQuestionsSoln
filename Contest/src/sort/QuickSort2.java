/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 20-Apr-2013
 * 
 */
public class QuickSort2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 3, 1, 6, 9, 10, 8, 4, 2, 15 };
		a = sort(a, 0, a.length - 1);
		System.out.println(a);
	}

	public static int[] sort(int[] a, int low, int high) {
		// Create a backup element.
		int i = low, j = high;
		// Create a pivot element.
		int pivot = a[low + (high - low) / 2];
		// Iterate though each element.
		while (i <= j) {
			// Get the element in array which is greater than pivot from
			// starting.
			while (a[i] < pivot) {
				i++;
			}
			// Get the element in array which is less than pivot from end.
			while (a[j] > pivot) {
				j--;
			}
			// Once the element is found then exchange it.
			if (i <= j) {
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
			}
		}
		// Recursively call the method from start to j.
		if (low < j) {
			sort(a, low, j);
		}
		// Recursively call the method from i to end.
		if (i < high) {
			sort(a, i, high);
		}
		return a;
	}
}
