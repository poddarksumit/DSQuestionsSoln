/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 17-Nov-2013
 * 
 */
public class TreeToCSPTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(5, new Node(2, null, null), new Node(5, null, null));
		Node n2 = new Node(3, null, null);
		Node n3 = new Node(7, n2, n1);
		Node n4 = new Node(1, null, null);
		Node n5 = new Node(50, n4, new Node(30, null, null));
		Node n = new Node(50, n3, n5);
		Node partn = convert(n, null, new ChangeAttr());
		System.out.println(partn);

	}

	public static Node convert(Node root, Node parent, ChangeAttr chngeAttr) {
		if ((root.left == null) && (root.right == null)) {
			return root;
		}
		Node left = new Node(0), right = new Node(0);
		if (root.left != null) {
			left = convert(root.left, root, chngeAttr);
		}
		if (root.right != null) {
			right = convert(root.right, root, chngeAttr);
		}
		if ((chngeAttr.data > -1) && (chngeAttr.toChange)) {
			if (root.left != null
					&& root.left.data < root.left.data + chngeAttr.data) {
				root.left.data = root.left.data + chngeAttr.data;
				left = root.left;
			} else if (root.right != null
					&& root.right.data < root.right.data + chngeAttr.data) {
				root.right.data = root.right.data + chngeAttr.data;
				right = root.right;
			}
			chngeAttr.data = -1;
			chngeAttr.toChange = false;
		}
		if ((left.data + right.data) > root.data) {
			if (parent == null) {
				root.data = left.data + right.data;
			} else {
				if (parent.left.data == root.data) {
					parent.left.data = left.data + right.data;
				} else {
					parent.right.data = left.data + right.data;
				}
			}
		} else if ((left.data + right.data) < root.data) {
			chngeAttr.data = root.data - (left.data + right.data);
			chngeAttr.toChange = true;
			convert(root, root, chngeAttr);
		}
		return root;
	}
}

class ChangeAttr {
	int data = -1;
	boolean toChange = false;

}
