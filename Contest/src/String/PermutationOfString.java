/**
 * 
 */
package String;

import java.util.ArrayList;

/**
 * This class is used to
 * 
 * @author Sumit 13-Mar-2013
 * 
 */
public class PermutationOfString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> llist = new ArrayList<String>();
		ArrayList<String> llist1 = new ArrayList<String>();
		String s = "ABC";
		System.out.println(getPermutiation(s, new char[s.length()], llist, 0));
		System.out.println(getPermutastinWithoutRep(s, new char[s.length()],
				llist1, 0, new int[256]));
	}

	public static ArrayList<String> getPermutiation(String str, char[] c,
			ArrayList<String> llist, int count) {
		if (count == str.length()) {
			llist.add(new String(c));
			return llist;
		}
		for (int i = 0; i < str.length(); i++) {
			c[count] = str.charAt(i);
			getPermutiation(str, c, llist, count + 1);
		}
		return llist;
	}

	public static ArrayList<String> getPermutastinWithoutRep(String s,
			char[] c, ArrayList<String> list, int count, int[] charCount) {
		if (count == s.length()) {
			list.add(new String(c));
			return list;
		}
		for (int i = 0; i < s.length(); i++) {
			if (charCount[s.charAt(i)] == 0) {
				charCount[s.charAt(i)] = 1;
				c[count] = s.charAt(i);
				getPermutastinWithoutRep(s, c, list, count + 1, charCount);
			}
		}

		return list;

	}
}
