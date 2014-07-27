package dp;

public class LCS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println(findLCS(str1.toCharArray(), str2.toCharArray()));

	}

	public static String findLCS(char[] str1, char[] str2) {
		int[] charMap = new int[256];
		char[] result = new char[str2.length];
		int index = 0, minIndex = -1;
		for (int i = 0; i < 256; i++) {
			charMap[i] = -1;
		}
		for (int i = 0; i < str1.length; i++) {
			charMap[str1[i]] = i;
		}
		for (int i = 0; i < str2.length; i++) {
			if ((charMap[str2[i]] > -1) && (minIndex < charMap[str2[i]])) {
				minIndex = charMap[str2[i]];
				result[index] = str2[i];
				index++;
			}
		}
		return new String(result);
	}
}
