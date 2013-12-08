/**
 * 
 */
package Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * This class is used to
 * 
 * @author Sumit 22-Jan-2013
 * 
 * @version $Revision: 1.0 $
 */
public class Palindrome {

	/**
	 * Field immEInt.
	 */
	/**
	 * Field eInt.
	 */
	/**
	 * Field sInt.
	 */
	static int sInt = -1, eInt = -1, immEInt = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		setImpl();
		/*
		 * String str = "Godlivere a dare vil dog";
		 * System.out.println("checkPalindrome : " + checkPalindrome(str));
		 * System.out.println("longestPalindrome : " + longestPalindrome(str));
		 * System.out.println("removeChar : " + removeChar(str, 'g'));
		 */

	}

	/**
	 * Method checkPalindrome.
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkPalindrome(String str) {
		boolean is = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (sInt == -1) {
				sInt = i;
			}
			if (eInt == -1) {
				if (immEInt == -1) {
					eInt = str.length() - i - 2;
				} else {
					eInt = str.length() - i - 1;
				}
			}
			char a = str.charAt(sInt);
			char b = str.charAt(eInt);
			if (a == ' ') {
				immEInt = -1;
				sInt = -1;
			} else if (b == ' ') {
				eInt = -1;
			} else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
				is = false;
				break;
			} else {
				sInt = -1;
				eInt = -1;
			}
		}
		return is;
	}

	/**
	 * Method checkPalindrome1.
	 * 
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean checkPalindrome1(String str) {
		boolean is = true;
		for (int i = 0; i < str.length() / 2; i++) {
			if (sInt == -1) {
				sInt = i;
			}
			if (eInt == -1) {
				if (immEInt == -1) {
					eInt = str.length() - i - 2;
				} else {
					eInt = str.length() - i - 1;
				}
			}
			char a = str.charAt(sInt);
			char b = str.charAt(eInt);
			if (a == ' ') {
				immEInt = -1;
				sInt = -1;
			} else if (b == ' ') {
				eInt = -1;
			} else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
				is = false;
				break;
			} else {
				sInt = -1;
				eInt = -1;
			}
		}
		return is;
	}

	/**
	 * Method longestPalindrome.
	 * 
	 * @param str
	 *            String
	 * @return int
	 */
	public static int longestPalindrome(String str) {
		int plen = 0, i = 0, n = str.length() - 1;
		while (i <= str.length() / 2 && n >= str.length() / 2) {
			System.out.println(i);
			System.out.println(Character.toLowerCase(str.charAt(i)));
			System.out.println(n);
			System.out.println(Character.toLowerCase(str.charAt(n)));

			if (str.charAt(i) == ' ') {
				i++;
				if (str.charAt(n) == ' ') {
					n--;
				}
			} else if (str.charAt(n) == ' ') {
				n--;
			} else {
				if (Character.toLowerCase(str.charAt(i)) == Character
						.toLowerCase(str.charAt(n))) {
					i++;
					n--;
					plen++;
				} else {
					break;
				}
			}
			System.out.println(plen);
			System.out.println("******************************");
		}
		return plen;
	}

	/**
	 * Method removeChar.
	 * 
	 * @param str
	 *            String
	 * @param a
	 *            char
	 * @return String
	 */
	public static String removeChar(String str, char a) {
		char[] array = new char[str.length()];
		int n = 0, i = 0;
		while (i < str.length()) {
			if (str.charAt(i) == a) {
				i++;
			} else {
				array[n] = str.charAt(i);
				i++;
				n++;
			}
			if (true) {
			} else {
			}
		}
		str = new String(array);
		return str;
	}

	/**
	 * Method setImpl.
	 */
	public static void setImpl() {
		int in;
		Set<Integer> set = new TreeSet<Integer>();
		set.add(4);
		set.add(1);
		for (Integer i : set) {
			System.out.println(i);
		}

	}
}
