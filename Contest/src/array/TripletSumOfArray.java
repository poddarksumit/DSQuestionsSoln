/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 23-Jun-2013
 * 
 */
public class TripletSumOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = { 12, 3, 4, 1, 6, 9 };
		val = quickSort(val, 0, val.length - 1);
		System.out.println(findTripletSum(val, 24));
	}

	public static int[] quickSort(int[] array, int low, int high) {
		int i = low, j = high;
		int pivoit = array[low + (high - low) / 2];
		while (i <= j) {
			while (array[i] < pivoit) {
				i++;
			}
			while (array[j] > pivoit) {
				j--;
			}

			if (i < j) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				j--;
			}
			i++;

		}

		if (low < j) {
			quickSort(array, low, j);
		}
		if (i < high) {
			quickSort(array, i, high);
		}
		return array;
	}

	public static boolean findTripletSum(int[] array, int x) {
		int sum = 0, i = 0, a = 0, j = array.length - 1;
		boolean bool = false;
		while ((!bool) && (a < array.length)) {
			while (i < j) {
				if (i == a) {
					i++;
				} else if (j == a) {
					j++;
				}

				else {
					if (array[i] + array[j] + array[a] == x) {
						System.out.println(array[a]);
						System.out.println(array[i]);
						System.out.println(array[j]);
						bool = true;
						break;
					} else if (array[i] + array[j] + array[a] > x) {
						j--;
					} else {
						i++;
					}
				}
			}
			sum = 0;
			i = 0;
			j = array.length - 1;
			a++;
		}
		return bool;
	}
}
