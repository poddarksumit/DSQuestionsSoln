package dp;

public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[151];
		array[1] = 1;
		for (int i = 1; i <= 150; i++) {
			array = isUgly(i, array);
			if (array[i] == 1) {
				System.out.println(i);
			}
		}

	}

	public static int[] isUgly(int i, int[] array) {
		if (i % 2 == 0) {
			if (array[i / 2] == 1) {
				array[i] = 1;
			}
		} else if (i % 3 == 0) {
			if (array[i / 3] == 1) {
				array[i] = 1;
			}
		} else if (i % 5 == 0) {
			if (array[i / 5] == 1) {
				array[i] = 1;
			}
		}
		return array;
	}
}
