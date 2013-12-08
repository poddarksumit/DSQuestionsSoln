/**
 * 
 */
package trie;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to
 * 
 * @author Sumit 07-Jul-2013
 * 
 */
public class TrieNode {

	private char letter;
	private Map<Character, TrieNode> child;
	int elementSize;

	public TrieNode(char letter) {
		super();
		this.letter = letter;
		this.child = new HashMap<Character, TrieNode>();
		elementSize = 0;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public Map<Character, TrieNode> getChild() {
		return child;
	}

	public void setChild(Map<Character, TrieNode> child) {
		this.child = child;
	}

	public int getElementSize() {
		return elementSize;
	}

	public void setElementSize(int elementSize) {
		this.elementSize = elementSize;
	}

}
