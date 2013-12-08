/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 18-Oct-2013
 * 
 */
public class MaxHeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 60, 8, 13, 90, 105, 2, 1 };
		buildHeap(array);
		sortArray(array);
		System.out.println(array);

	}

	public static void buildHeap(int[] array) {
		for (int i = ((array.length - 1 / 2)); i >= 0; i--) {
			heapify(array, i);
		}
	}

	public static void heapify(int[] array, int i) {
		int larg;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		if ((left < array.length) && (array[left] >= array[i])) {
			larg = left;
		} else {
			larg = i;
		}
		if ((right < array.length) && (array[right] >= array[larg])) {
			larg = right;
		}

		if (larg != i) {
			int temp = array[i];
			array[i] = array[larg];
			array[larg] = temp;
			heapify(array, larg);
		}
	}

	public static void heapify(int[] array, int i, int size) {
		int larg;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		if ((left < size) && (array[left] >= array[i])) {
			larg = left;
		} else {
			larg = i;
		}
		if ((right < size) && (array[right] >= array[larg])) {
			larg = right;
		}

		if (larg != i) {
			int temp = array[i];
			array[i] = array[larg];
			array[larg] = temp;
			heapify(array, larg, size);
		}
	}

	public static void sortArray(int[] array) {
		for (int index = array.length - 1; index >= 0; index--) {
			int temp = array[index];
			array[index] = array[0];
			array[0] = temp;
			heapify(array, 0, index);
		}
	}
}
