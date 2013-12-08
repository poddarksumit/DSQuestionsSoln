package String;

public class KnuthMorrisPratt {

	public static void main(String[] args) {
		String string = "abcaaabbabca";
		String pattern = "abca";
		int[] patternMatchTable = createPartialMatchTable(pattern);
		searhcWord(string, pattern, patternMatchTable);

		KMPMatch match = new KMPMatch(string, pattern);
		System.out.println(match.match());
		System.out.println(patternMatchTable);
	}

	/*
	 * Steps to validate : take letters till the index inclusing. String pattern
	 * = "ababaca" Say for index 4. Proper Prefix : a,ab,aba,abab Proper Suffix
	 * : baba,aba,ba,a. Common letter is only of 3 length
	 */
	public static int[] createPartialMatchTable(String pattern) {
		int[] matchTable = new int[pattern.length()];
		matchTable[0] = 0;
		int k = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while ((k > 0) && (pattern.charAt(k) != pattern.charAt(i))) {
				k = matchTable[k - 1];
			}
			if (pattern.charAt(k) == pattern.charAt(i)) {
				k += 1;
			}
			matchTable[i] = k;
		}
		return matchTable;
	}

	public static void searhcWord(String string, String patter, int[] matcher) {

		int q = 0, start = -1;
		for (int i = 0; i < string.length(); i++) {
			while (q > 0 && patter.charAt(q) != string.charAt(i)) {
				q = matcher[q - 1];
			}
			if (patter.charAt(q) == string.charAt(i)) {
				if (start == -1) {
					start = i;
				}
				q += 1;
			} else {
				start = -1;
			}
			if (q == patter.length()) {
				System.out.println("String found index : " + start + " : "
						+ (i));
				q = matcher[q - 1];
			}

		}

	}
}