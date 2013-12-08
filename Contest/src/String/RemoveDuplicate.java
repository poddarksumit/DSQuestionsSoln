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
public class RemoveDuplicate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(remDup("this is sumit and he lives in chennai."));
		printDup("geeksforgeeks");
		String x = "this is sumit and he lives in chennai";
		System.out.println(new String(revrecur(x, new char[x.length()], 0)));
		System.out.println(revReccur(revrecur(x, new char[x.length()], 0)));
		System.out.println(revReccur(getRevChar(x.toCharArray(), 0,
				x.length() - 1, 0)));
		System.out.println(new String(getRevChar(x.toCharArray(), 0,
				x.length() - 1, 0)));
	}

	public static String remDup(String s) {
		char[] chars = new char[s.length()];
		int index = 0;
		int[] charCount = new int[256];
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			charCount[a] += 1;
			if (charCount[a] == 1) {
				chars[index] = a;
				index++;
			}
		}
		return new String(chars);
	}

	public static void printDup(String s) {
		int[] charCount = new int[256];
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			charCount[a] += 1;
			if (charCount[a] == 2) {
				System.out.println(a);
			}
		}
	}

	public static char[] revrecur(String s, char[] c, int i) {
		if (s.length() > 1) {
			i++;
			c = revrecur(s.substring(1), c, i);
		}
		if (s.length() == 1) {
			c[0] = s.charAt(0);
		} else {
			c[c.length - i] = s.charAt(0);
		}
		return c;
	}

	public static String revReccur(char[] c) {
		int sIndex = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c = getRevChar(c, sIndex, i - 1, sIndex);
				sIndex = i + 1;
			}
		}
		if (sIndex != c.length) {
			c = getRevChar(c, sIndex, c.length - 1, sIndex);
		}
		return new String(c);
	}

	public static char[] getRevChar(char[] c, int sINdex, int endIndex,
			int sINdexTemp) {
		if (sINdex > endIndex) {
			return c;
		}
		char a = c[sINdex];
		c = getRevChar(c, sINdex + 1, endIndex, sINdexTemp);
		c[sINdexTemp + (endIndex - sINdex)] = a;
		return c;
	}
}
