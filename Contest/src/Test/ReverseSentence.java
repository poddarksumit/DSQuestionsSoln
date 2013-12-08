/**
 * 
 */
package Test;

/**
 * This class is used to
 * 
 * @author Sumit 22-Jan-2013
 * 
 */
public class ReverseSentence {
	static String str;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "I am going to Bangalore";
		System.out.println(reverseRecursively(str));
	}

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

	public static String replace(String strTemp, String rep) {
		String newStr = "";
		if ((str != null) && (!"".equals(str))) {
			int length = strTemp.length();
			int i = 0;
			while (i < str.length()) {
				if (str.charAt(i) == strTemp.charAt(0)) {
					String str1 = str.substring(i, length + i);
					if (str1.equals(strTemp)) {
						str = str
								.substring(0, i)
								.concat(rep)
								.concat(str.substring(i + length, str.length()));
						i = i + length;
					} else {
						i++;
					}
				} else {
					i++;
				}

			}
		} else {
			str = "NA";
		}
		return str;
	}

}
