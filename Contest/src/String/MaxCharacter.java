/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 08-Mar-2013
 * 
 */
public class MaxCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxChar("this is sumit."));
		System.out.println(getMaxChar("this tt is sumit."));

		System.out.println(getMaxCharRecc("thsi si iumst.", ' ', new int[256]));
		System.out.println(getMaxCharRecc("this tt is sumit.", ' ',
				new int[256]));
	}

	public static char getMaxChar(String s) {
		char maxChar = ' ';
		int[] charCount = new int[256];
		for (int i = 0; i < s.length(); i++) {
			char z = s.charAt(i);
			charCount[z] += 1;
			if (maxChar != ' ') {
				if (charCount[z] > charCount[maxChar]) {
					maxChar = z;
				}
			} else {
				maxChar = z;
			}
		}
		return maxChar;
	}

	public static char getMaxCharRecc(String s, char c, int[] cCount) {
		char cTemp = s.charAt(0);
		cCount[cTemp] += 1;
		if (s.length() > 1) {
			c = getMaxCharRecc(s.substring(1), c, cCount);
		}
		if (c == ' ') {
			c = cTemp;
		} else {
			if (cCount[cTemp] > cCount[c]) {
				c = cTemp;
			}
		}
		return c;
	}
}
