package array;

public class ArrayRoatdFindIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 10, 20, 25, 30, 35, 40, 45 };
		System.out.println(findRotatedIndex(array, 0, array.length, 0));

	}

	public static int findRotatedIndex(int[] array, int start, int end, int min) {
		if (start <= end) {
			int mid = start + ((end - start) / 2);
			if ((mid == 0) || (mid == array.length - 1)) {
				if (array[mid] <= array[min]) {
					return mid;
				}
			} else if ((array[mid] < array[mid + 1])
					&& (array[mid] < array[mid - 1])) {
				if (array[mid] <= array[min]) {
					return mid;
				}
			} else {
				min = findRotatedIndex(array, start, mid - 1, min);
				min = findRotatedIndex(array, mid + 1, end, min);
			}
		}
		return min;
	}
}
