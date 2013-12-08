/**
 * 
 */
package Test;

/**
 * This class is used to
 * 
 * @author Sumit 07-Feb-2013
 * 
 */
public class Test {
	static boolean[] bool = new boolean[256];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(reverse("abctgs"));
		String str1 = "aaabbw";
		String str2 = "bbaaa";
		int[] bool = new int[256];
		if (str1.length() == str2.length()) {
			bool = check(str1, bool);
			System.out.println(checkStr1(str2, bool));
		} else {
			System.out.println("invalid");
		}
	}

	public static String reverse(String a) {
		char[] c = new char[a.length() + 1];
		int j = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			j++;
			c[j] = a.charAt(i);
		}
		a = new String(c);
		return a;
	}

	public static int[] check(String str, int[] bool) {
		for (int i = 0; i < str.length(); i++) {
			if (bool[str.charAt(i)] == 0) {
				bool[str.charAt(i)] = 1;
			} else {
				int num = bool[str.charAt(i)];
				bool[str.charAt(i)] = ++num;
			}
		}
		return bool;
	}

	public static boolean checkStr1(String str, int[] bool) {
		int i = 0;
		boolean isAnagram = true;
		while ((isAnagram) && (i < str.length())) {
			if (bool[str.charAt(i)] == 0) {
				isAnagram = false;
			} else {
				int num = bool[str.charAt(i)];
				bool[str.charAt(i)] = --num;
			}
			i++;
		}
		return isAnagram;
	}

	public static String rep(char[] c) {
		if ((c != null) && (c.length > 0)) {
			for (int i = 0; i < c.length; i++) {
				if (' ' == c[i]) {
					// c[i] = '%20';
				}
			}
		}
		return null;
	}
}
