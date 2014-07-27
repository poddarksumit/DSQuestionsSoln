/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 21-Oct-2013
 * 
 */
public class MinHeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 60, 8, 13, 90, 105, 2, 1 };
		buildHeap(array);
		System.out.println("--- Heaped ---");
		for (int i : array) {
			System.out.println(i);
		}
		sortArray(array);
		System.out.println("--- Sorted ---");
		for (int i : array) {
			System.out.println(i);
		}

	}

	public static void buildHeap(int[] array) {
		for (int index = (array.length - 1) / 2; index >= 0; index--) {
			heapify(array, index, array.length);
		}
	}

	public static void heapify(int[] array, int index, int size) {
		int small = index;
		int left = (2 * index) + 1;
		int right = (2 * index) + 2;

		if ((left < size) && (array[left] < array[index])) {
			small = left;
		}
		if ((right < size) && (array[right] < array[small])) {
			small = right;
		}

		if (small != index) {
			int temp = array[small];
			array[small] = array[index];
			array[index] = temp;
			heapify(array, small, size);
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
