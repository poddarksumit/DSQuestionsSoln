/**
 * 
 */
package array;

/**
 * This class is used to
 * 
 * @author Sumit 13-Mar-2013
 * 
 */
public class GetOddOccurence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2 };
		System.out.println(getOddOccurrence(ar, ar.length));
	}

	public static int getOddOccurrence(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++)
			res = res ^ ar[i];

		return res;
	}
}
