package trie;


public class LongestPrfxMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] dictionary = { "are", "area", "base", "cat", "cater",
				"children", "basement", "baseme" };

		TrieNode root = new TrieNode('\0');
		for (String dict : dictionary) {
			root = TrieUtil.insertWord(root, dict);
		}
		System.out.println(getMatchedStrng(root, "catereing"));
	}

	public static String getMatchedStrng(TrieNode root, String word) {
		char[] toChar = word.toCharArray();
		TrieNode current = root;
		int i = 0;
		for (; i < toChar.length; i++) {
			if (current.getChild().get(toChar[i]) == null) {
				break;
			} else {
				current = current.getChild().get(toChar[i]);
			}
		}
		return word.substring(0, i);

	}
}
