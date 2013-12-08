/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 01-Nov-2013
 * 
 */
public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("abcd", "dbcaa"));
	}

	public static boolean isAnagram(String s, String t) {
		int[] sCountArray = new int[256];
		int tCount = 0;
		boolean isAnagram = true;
		for (char sChar : s.toCharArray()) {
			sCountArray[sChar] += 1;
		}

		while ((isAnagram) && (tCount < t.length())) {

			if (sCountArray[t.charAt(tCount)] > 0) {
				sCountArray[t.charAt(tCount)] -= 1;
			} else {
				isAnagram = false;
			}
			tCount++;
		}
		return isAnagram;
	}
}
