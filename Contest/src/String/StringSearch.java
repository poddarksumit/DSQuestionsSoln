/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 10-Mar-2013
 * 
 */
public class StringSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// searchString("this is a test string", "test");
		searchString("AAAAAAAAAAAAAAAAAB", "AAAAB");
	}

	public static void searchString(String s1, String s2) {
		int index1 = -1, index2 = 0;
		for (int i = 0; i < s1.length(); i++) {
			// System.out.println(s1.charAt(i));
			if (s1.charAt(i) == s2.charAt(index2)) {
				if (index1 == -1) {
					index1 = i;
				}
				index2++;
			} else {

				if (s1.charAt(i) == s2.charAt(0)) {
					index1 = i;
					index2 = 0;
				} else {

					index1 = -1;
					index2 = 0;
				}
			}

			if (index2 == s2.length()) {
				System.out.println("Index pos : " + index1);
				index1 = -1;
				index2 = 0;
			}
		}
	}
}
