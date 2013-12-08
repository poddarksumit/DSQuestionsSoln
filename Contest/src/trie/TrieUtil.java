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

	/**
	 * @param args
	 */
	static public void main(String[] args) {
		// TODO Auto-generated method stub
		TrieNode node = insertWord(new TrieNode('\0'), "Shawn Micheal");
		node = insertWord(node, "Shawne Micheal");
		System.out.println(wordExists(node, "Shawn Micheale"));
	}

	public static void main(String[] args, int index) {
		// TODO Auto-generated method stub
		Integer inte = Integer.MAX_VALUE;
		System.out.println(inte);
	}

	public static TrieNode insertWord(TrieNode root, String word) {
		TrieNode current = root;
		if ((word != null) && (!"".equals(word))) {
			for (char c : word.toCharArray()) {
				if (current.getChild().get(c) == null) {
					current.getChild().put(c, new TrieNode(c));
				}
				current = current.getChild().get(c);
			}
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
