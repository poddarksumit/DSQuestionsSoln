/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 26-May-2013
 * 
 */
public class RemoveBAndAcFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String removeBAndAC(String str) {
		char[] newCharList = new char[str.length()];
		char[] old = str.toCharArray();
		int i = 0, j = 1;
		while (j < str.length()) {
			if (old[i] == 'a') {
				if (old[j] == 'c') {

				} else {

				}
			}

		}
		return "";

	}
}
