/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 02-Oct-2013
 * 
 */
public class OddNoOcc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arg = { 7, 3, 5, 4, 5, 2, 2, 4, 3, 5, 2, 6, 6, 2, 7 };

		// int[] arg = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		System.out.println(process(arg, arg.length));
		System.out.println(process(arg));
	}

	public static int process(int[] arg) {
		int oddNoVal = -1;
		int oddNoCount = -1;
		int[] auxArray = new int[100];
		int count = 0;

		for (int i = 0; i < arg.length; i++) {
			if (auxArray[arg[i]] != 0) {
				count = auxArray[arg[i]] + 1;
			} else {
				count = 1;
			}
			auxArray[arg[i]] = count;
			if (count % 2 != 0) {
				if (count > oddNoCount) {
					oddNoCount = count;
					oddNoVal = arg[i];
				}
			}
		}
		return oddNoVal;
	}

	public static int process(int[] ar, int ar_size) {
		int i, j, res;
		i = 0;
		j = ar_size - 1;
		res = 0;
		while (i < ar_size / 2)
			res = res - ar[i++] + ar[j--];
		res = res - ar[i];
		return Math.abs(res);
	}
}
