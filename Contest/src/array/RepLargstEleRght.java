package array;

public class RepLargstEleRght {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {16, 17, 4, 5, 15, 2};
		array = replaceElementWdLrgstOnRght(array);
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static int[] replaceElementWdLrgstOnRght(int[] array) {
		int max = -1;
		for (int i = array.length - 1; i >= 0; i--) {
			int temp = array[i];
			array[i] = max;
			if (temp > max) {
				max = temp;
			}
		}
		return array;
	}
}
