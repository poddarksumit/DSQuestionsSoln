/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 12-Mar-2013
 * 
 */
public class LongestSubStringWdoutRepWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("Max Length : " +
		 * getLongestSubStringWdoutRepWords("geeksforgeeks"));
		 * System.out.println("-----------------");
		 * System.out.println("Max Length : " +
		 * getLongestSubStringWdoutRepWords("aabccczxygped"));
		 * System.out.println("-----------------");
		 * System.out.println("Max Length : " +
		 * getLongestSubStringWdoutRepWords("aaaabcd"));
		 */System.out.println("-----------------");
		System.out.println("Max Length : "
				+ getLongestSubStringWdoutRepWords("aabccczxygped"));

		System.out.println("-----------------");
		System.out.println("Max Length : "
				+ getLongestSubString("aabccczxygped"));
		System.out.println("-----------------");

	}

	/**
	 * Time Complxity = worst case O(n*(n-1)) for in/p : abcdeff
	 */
	public static int getLongestSubString(String str) {
		int start = 0, maxLength = 0, maxTemp = 0;
		int[] count = new int[256];
		int i = 0;
		for (; i < str.length(); i++) {
			count[str.charAt(i)] += 1;
			if (count[str.charAt(i)] > 1) {
				maxTemp = i - start;
				if (maxTemp > maxLength) {
					maxLength = maxTemp;
				}
				while ((start <= i) && (count[str.charAt(i)] > 1)) {
					count[str.charAt(start)] -= 1;
					start += 1;
				}
			}
		}
		maxTemp = i - start;
		if (maxTemp > maxLength) {
			maxLength = maxTemp;
		}
		return maxLength;
	}

	/**
	 * Approach is to store the index and start with that.
	 */
	public static int getLongestSubStringWdoutRepWords(String s) {
		int[] x = new int[256];
		int maxLenTemp = 0, maxLength = 0;
		int i = 0;
		for (; i < s.length(); i++) {
			x[s.charAt(i)] = -1;
		}
		i = 0;
		for (; i < s.length(); i++) {
			if (x[s.charAt(i)] == -1) {
				x[s.charAt(i)] = i;
				maxLenTemp++;
			} else {
				if (maxLenTemp > maxLength) {
					maxLength = maxLenTemp;
				}
				maxLenTemp = i - maxLenTemp;
				x[s.charAt(i)] = i;
			}
		}
		if (maxLenTemp > maxLength) {
			maxLength = maxLenTemp;
		}
		return maxLength;
	}
}
