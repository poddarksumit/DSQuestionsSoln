/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 21-Apr-2013
 * 
 */
public class GetProductArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 10, 3, 5, 6, 2 };
		a = getProduct(a, a.length);
		System.out.println(a);
	}

	public static int[] getProduct(int[] a, int n) {
		int[] lProd = new int[a.length];
		int[] rProd = new int[a.length];
		lProd[0] = 1;
		rProd[n - 1] = 1;
		for (int i = 1; i < a.length; i++) {
			lProd[i] = a[i - 1] * lProd[i - 1];
		}
		for (int j = n - 2; j >= 0; j--) {
			rProd[j] = a[j + 1] * rProd[j + 1];
		}
		for (int i = 0; i < a.length; i++) {
			a[i] = lProd[i] * rProd[i];
		}
		return a;
	}
}
