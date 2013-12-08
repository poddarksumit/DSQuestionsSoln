/**
 * 
 */
package sort;

/**
 * This class is used to
 * 
 * @author Sumit 13-Mar-2013
 * 
 */
public class MergeSortTemp {

	static int[] help;
	static int[] num;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] val = { 3, 2, 7, 1, 9, 10 };
		int x = 0;
		sort(val);
		System.out.println(num);

	}

	public static void sort(int[] sort) {
		num = sort;
		help = new int[sort.length];
		mergeSort(0, sort.length - 1);

	}

	public static void mergeSort(int low, int high) {
		if (low < high) {
			int mid = low + ((high - low) / 2);
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high) {
		for (int i = low; i <= high; i++) {
			help[i] = num[i];
		}
		int i = low, k = low, j = mid + 1;
		while ((i <= mid) && (j <= high)) {
			if (help[i] <= help[j]) {
				num[k] = help[i];
				i++;
			} else {
				num[k] = help[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			num[k] = help[i];
			k++;
			i++;
		}
	}
}
