/**
 * 
 */
package Test;

/**
 * This class is used to
 * 
 * @author Sumit 01-Feb-2013
 * 
 * @version $Revision: 1.0 $
 */
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(factRec(5));

	}

	public static int fact(int n) {
		int prod = 1;
		for (int i = n; i > 0; i--) {
			prod *= i;
		}

		return prod;

	}

	public static int factRec(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factRec(n - 1);
		}

	}

}
