package Tree.redBlackTree;

public class LeftRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RBNode rbNode = new RBNode(30, left, right, null, RBTreeColor.BLACK);

	}

	public static void leftRotation(RBNode tree, RBNode node){
		RBNode rghtNodeBkp = (RBNode) node.getRight();
		node.setRight(rghtNodeBkp.getLeft());
		if(rghtNodeBkp.getLeft() != null){
			((RBNode)rghtNodeBkp.getLeft()).setParent(node);
		}
		rghtNodeBkp.setParent(node.getParent());
		if(tree == null){
			tree = rghtNodeBkp;
		}
		else if(node == node.getParent().getLeft()){
			node.getParent().setLeft(rghtNodeBkp);
		}else {
			node.getParent().setRight(rghtNodeBkp);
		}
		rghtNodeBkp.setLeft(node);
		node.setParent(rghtNodeBkp);
	}
}
