package array;

public class FindSum4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 2, 3, 4, 5, 7, 8, 9, 10 };
		find4ElmentForSum(A, 23);

	}

	public static void find4ElmentForSum(int[] array, int sum) {
		for (int i = 0; i < array.length - 3; i++) {
			for (int j = i + 1; j < array.length - 2; j++) {
				int start = j + 1;
				int end = array.length - 1;
				int sumToGet = sum - (array[i] + array[j]);
				while (start < end) {
					int sumRcvd = array[start] + array[end];
					if (sumRcvd == sumToGet) {
						System.out.println(array[i]);
						System.out.println(array[j]);
						System.out.println(array[start]);
						System.out.println(array[end]);
						break;
					} else if (sumRcvd < sumToGet) {
						start++;
					} else if (sumRcvd > sumToGet) {
						end--;
					}

				}
				System.out.println("Found");
			}
		}
	}
}
