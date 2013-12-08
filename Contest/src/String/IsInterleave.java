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
public class IsInterleave {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleave("ABBC", "ABDC", "AABBDCBC"));
		System.out.println(isInterleave("AAB", "AAC", "AAABAC", false));
	}

	public static boolean isInterleave(String A, String B, String C) {
		int aCount = 0, bCount = 0, cCount = 0;
		boolean isInterleave = (C.length() > 0) ? true : false;
		while ((isInterleave) && (cCount < C.length())) {
			if ((A.length() > 0) && (aCount < A.length())
					&& (C.charAt(cCount) == A.charAt(aCount))) {
				aCount++;
				isInterleave = true;

			} else if ((B.length() > 0) && (bCount < B.length())
					&& (C.charAt(cCount) == B.charAt(bCount))) {
				bCount++;
				isInterleave = true;
			} else {
				isInterleave = false;
			}
			cCount++;
		}
		if (!((aCount == A.length()) && (bCount == B.length()))) {
			isInterleave = false;
		}
		return isInterleave;
	}

	public static boolean isInterleave(String A, String B, String C,
			boolean isInterlve) {
		if (C.length() == 0) {
			if (!(A.length() == 0 && B.length() == 0)) {
				isInterlve = false;
			}
			return isInterlve;
		} else if (A.length() == 0 && B.length() == 0) {
			return false;
		}
		isInterlve = true;
		if ((A.length() > 0) && (A.charAt(0) == C.charAt(0))) {
			return isInterleave(A.substring(1), B, C.substring(1), true);
		} else if ((B.length() > 0) && (B.charAt(0) == C.charAt(0))) {
			return isInterleave(A, B.substring(1), C.substring(1), true);
		} else {
			return false;
		}

	}
}
