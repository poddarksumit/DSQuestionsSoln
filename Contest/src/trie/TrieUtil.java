/**
 * 
 */
package trie;

/**
 * This class is used to
 * 
 * @author Sumit 07-Jul-2013
 * 
 */
public class TrieUtil {

	public static TrieNode insertWord(TrieNode root, String word) {
		TrieNode current = root;
		int i = 0;
		if ((word != null) && (!"".equals(word))) {
			char[] c = word.toCharArray();
			for (; i < c.length; i++) {
				if (current.getChild().get(c[i]) == null) {
					current.getChild().put(
							c[i],
							new TrieNode(c[i], (i == c.length - 1) ? true
									: false));
				}
				current = current.getChild().get(c[i]);
			}
			current.setEnd(true);
		}
		return root;
	}

	public static boolean wordExists(TrieNode root, String word) {
		boolean isWordPresent = true;
		TrieNode currentNode = root;
		for (char c : word.toCharArray()) {
			if (currentNode.getChild().get(c) == null) {
				isWordPresent = false;
				break;
			} else {
				currentNode = currentNode.getChild().get(c);
			}
		}
		return isWordPresent;
	}

	public static boolean deleteWord(TrieNode root, TrieNode prevRoot,
			char[] charArray, int index, int total, boolean found) {
		if (root == null) {
			found = false;
		}
		if ((total == (index - 1))
				&& (root.getChild().get(charArray[index]) != null)) {
			found = true;
		}
		if (root.getChild().get(charArray[index]) == null) {
			found = false;
		} else {
			if (index == 0) {
				found = deleteWord(root.getChild().get(charArray[index]), root
						.getChild().get(charArray[index - 1]), charArray,
						index + 1, total, found);
			} else {
				found = deleteWord(root.getChild().get(charArray[index]), root
						.getChild().get(charArray[index - 1]), charArray,
						index + 1, total, found);
			}

		}
		if (found) {
			prevRoot.getChild().put(charArray[index], null);
		}
		return found;
	}
}
