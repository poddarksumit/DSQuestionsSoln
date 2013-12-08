/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 10-Mar-2013
 * 
 */
public class SmallestWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getSmallestWindow("this is a test string", "tist");
		getSmallestWindow("ADOBECODEBANC", "ABC");
	}

	public static void getSmallestWindow(String s1, String s2) {
		int[] charCount1 = new int[256];
		int[] charCount2 = new int[256];
		int index1 = 0, index2 = 0, begin = 0, end = 0, min = 0, start = -1;
		for (int i = 0; i < s2.length(); i++) {
			charCount2[s2.charAt(i)] += 1;
			index2++;
		}
		for (int j = 0; j < s1.length(); j++) {
			if (charCount2[s1.charAt(j)] > 0) {
				if (start == -1) {
					start = j;
				}
				charCount1[s1.charAt(j)] += 1;
				if (charCount1[s1.charAt(j)] <= charCount2[s1.charAt(j)]) {
					index1++;
				}

				if (index1 == index2) {
					while ((charCount2[s1.charAt(start)] == 0)
							|| (charCount1[s1.charAt(start)] > charCount2[s1
									.charAt(start)])) {
						if (charCount1[s1.charAt(start)] > charCount2[s1
								.charAt(start)]) {
							charCount1[s1.charAt(start)]--;
						}
						start++;
					}

					int min_len = j - start;
					if ((min == 0) || (min_len < min)) {
						min = min_len;
						begin = start;
						end = j;
					}
				}
			}
		}
		System.out.println(s1.substring(begin, end + 1));
	}
}

// Returns false if no valid window is found. Else returns
// true and updates minWindowBegin and minWindowEnd with the
// starting and ending position of the minimum window.
/**
 * bool minWindow(const char* S, const char *T, int &minWindowBegin, int
 * &minWindowEnd) { int sLen = strlen(S); int tLen = strlen(T); int
 * needToFind[256] = {0};
 * 
 * for (int i = 0; i < tLen; i++) needToFind[T[i]]++;
 * 
 * int hasFound[256] = {0}; int minWindowLen = INT_MAX; int count = 0; for (int
 * begin = 0, end = 0; end < sLen; end++) { // skip characters not in T if
 * (needToFind[S[end]] == 0) continue; hasFound[S[end]]++; if (hasFound[S[end]]
 * <= needToFind[S[end]]) count++;
 * 
 * // if window constraint is satisfied if (count == tLen) { // advance begin
 * index as far right as possible, // stop when advancing breaks window
 * constraint. while (needToFind[S[begin]] == 0 || hasFound[S[begin]] >
 * needToFind[S[begin]]) { if (hasFound[S[begin]] > needToFind[S[begin]])
 * hasFound[S[begin]]--; begin++; }
 * 
 * // update minWindow if a minimum length is met int windowLen = end - begin +
 * 1; if (windowLen < minWindowLen) { minWindowBegin = begin; minWindowEnd =
 * end; minWindowLen = windowLen; } // end if } // end if } // end for
 * 
 * return (count == tLen) ? true : false; }
 */
