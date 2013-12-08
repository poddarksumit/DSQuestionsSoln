/**
 * 
 */
package Test;

/**
 * This class is used to
 * 
 * @author Sumit 28-Feb-2013
 * 
 */
public class LargestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String s = "forgeekskeegror";
		String s = "forgeegskeegror";
		String stemp = getLongestPalindrome(s);
		System.err.println(stemp);
	}

	public static String getLongestPalindrome(String s) {
		int len = s.length();
		int mid = len / 2;
		int b, c;

		if (len % 2 == 0) {
			b = mid - 1;
			c = mid;
		} else {
			b = mid - 1;
			c = mid + 1;
		}
		boolean isPalingExits = true;
		while ((isPalingExits) && ((b >= 0) && (c < s.length()))) {
			if (s.charAt(b) != s.charAt(c)) {
				isPalingExits = false;
			} else {
				b--;
				c++;
			}
		}

		return s.substring(b + 1, c);
	}
}
