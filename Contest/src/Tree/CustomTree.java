package Tree;

import java.util.HashMap;

public class CustomTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] head = { 'b', 'a', 'a', 'c', 'd', 'c' };
		char[] tail = { 'c', 'b', 'g', 'd', 'e', 'f' };
		NodeChar headNodeChar = createTree(head, tail);
		System.out.println(headNodeChar);
	}

	public static NodeChar createTree(char[] head, char[] tail) {
		if ((head.length == 0) || (tail.length == 0)
				|| (head.length != tail.length)) {
			return null;
		}
		int index = 0;
		NodeChar headNodeChar = null;
		HashMap<Character, NodeChar> charMap = new HashMap<Character, NodeChar>();
		HashMap<Character, Character> tailHeadMap = new HashMap<Character, Character>();
		while (index < head.length) {
			if (!charMap.containsKey(head[index])) {
				NodeChar node = new NodeChar(head[index]);
				if (!tailHeadMap.containsKey(head[index])) {
					node.left = new NodeChar(tail[index]);
					charMap.put(head[index], node);
				} else {
					node = charMap.get(tailHeadMap.get(head[index]));
					NodeChar temp = null;
					if (node.left.data == head[index]) {
						temp = node.left;
					} else {
						temp = node.right;
					}
					if (temp.left == null) {
						temp.left = new NodeChar(tail[index]);
					} else {
						temp.right = new NodeChar(tail[index]);
					}
					node.left = temp;
					charMap.put(head[index], temp);
					charMap.put(tailHeadMap.get(head[index]), node);
				}
				if (headNodeChar == null) {
					headNodeChar = node;
				}

			} else {
				NodeChar node = charMap.get(head[index]);
				if (!charMap.containsKey(tail[index])) {
					node.right = new NodeChar(tail[index]);
					if (headNodeChar.data == tail[index]) {
						headNodeChar = node;
					}
				} else {
					node.right = charMap.get(tail[index]);
				}
			}
			tailHeadMap.put(tail[index], head[index]);
			index++;
		}
		return headNodeChar;
	}
}
