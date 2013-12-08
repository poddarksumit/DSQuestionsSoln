/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 09-Mar-2013
 * 
 */
public class RunLengthEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(soRunLengthEncoding("wwwdcrwwrcdd"));
	}

	public static String soRunLengthEncoding(String s) {
		int[] charCount = new int[256];
		StringBuffer newString = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i)] += 1;
		}

		for (int i = 0; i < s.length(); i++) {
			if (charCount[s.charAt(i)] > 0) {
				newString.append(s.charAt(i));
				newString.append(charCount[s.charAt(i)]);
				charCount[s.charAt(i)] = 0;
			}
		}
		return newString.toString();
	}
}
