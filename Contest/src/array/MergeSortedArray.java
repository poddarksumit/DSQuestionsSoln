package array;

public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1 = { 3, 6, 9, 12 };
		int[] a2 = { 1, -1, 4, 8, -1, 10, -1, -1, 11 };
		int[] a = mergeStortedArray(a1, a2);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int[] mergeStortedArray(int[] a1, int[] a2) {
		int a2Index = a2.length - 1, a1Index = a1.length - 1;
		a2 = omitSpaces(a2);
		int index = a2[a2.length - 1] - 1;
		a2[a2.length - 1] = -1;
		while ((a1Index >= 0) && (index >= 0) && (a2Index >= 0)) {
			if (a1[a1Index] > a2[index]) {
				a2[a2Index] = a1[a1Index];
				a1Index--;
			} else if (a1[a1Index] < a2[index]) {
				a2[a2Index] = a2[index];
				index--;
			}
			a2Index--;
		}
		return a2;
	}

	public static int[] omitSpaces(int[] array) {
		int index = 0, runIndex = 0;
		while (runIndex < array.length) {
			if (array[index] == -1) {
				if (array[runIndex] > -1) {
					array[index] = array[runIndex];
					array[runIndex] = -1;
					index++;
				}
			} else {
				index++;
			}
			runIndex++;
		}
		array[array.length - 1] = index;
		return array;
	}
}
