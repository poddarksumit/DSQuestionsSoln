/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 23-Jun-2013
 * 
 */
public class BuildTreeInPre {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] inOrder = { 'E', 'A', 'C', 'K', 'F', 'H', 'D', 'B', 'G' };
		char[] preOrder = { 'F', 'A', 'E', 'K', 'C', 'D', 'H', 'G', 'B' };
		NodeChar n = null;
		if (inOrder.length == preOrder.length) {
			n = get(inOrder, preOrder, 0, inOrder.length, 0);
		}
		System.out.println("Done");
	}

	public static NodeChar get(char[] inorder, char[] pre, int start, int end,
			int preIndex) {
		NodeChar n = null;
		if (start <= end) {
			n = new NodeChar(pre[preIndex]);
			preIndex += 1;
			int index = searchIndex(inorder, start, end, n.data);
			if (index == -1) {
				return null;
			}
			n.left = get(inorder, pre, start, index - 1, preIndex);
			n.right = get(inorder, pre, index + 1, end, preIndex + 1);
		}
		return n;
	}

	public static int searchIndex(char[] inorder, int start, int end, int val) {
		int i = start;
		boolean isFind = false;
		if (start == end) {
			if (inorder[start] == val) {
				isFind = true;
				i = start;
			}
		} else {
			for (; i < end; i++) {
				if (inorder[i] == val) {
					isFind = true;
					break;
				}
			}

		}
		if (!isFind) {
			i = -1;
		}
		return i;
	}
}

