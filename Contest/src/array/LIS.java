package array;

public class LIS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		System.out.println(getSizeOfLongstIncSubSeq(array));
	}

	public static int getSizeOfLongstIncSubSeq(int[] array) {
		int size = 1, max = array[0];
		for (int i = 1; i < array.length; i++) {
			if ((array[i - 1] < array[i]) && (max < array[i])) {
				size++;
				System.out.println(array[i]);
				max = array[i];
			}
		}
		return size;
	}
}
