/*
 * Copyright (C) 2009 Woolworths Limited
 *
 * 1 Woolworths Way Bella Vista NSW 2153 Australia
 * All rights reserved.
 * This software is the confidential and proprietary information of Woolworths Limited. You shall not disclose
 * such confidential information and shall use it only in accordance with the terms of the licence agreement
 * you entered into with Woolworths Limited.
 * No part of this document may be presented, reproduced or copied in any form or by any means (graphical,
 * electronic or mechanical including photocopying, recording tape or by any information storage and
 * retrieval system) without the express written permission of Woolworths Ltd.
 * Unpublished work.
 */
package Tree.redBlackTree;

import java.util.TreeSet;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class RBTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RBNode root = new RBNode();
		root = insert(null, 1);
		root = insert(root, 3);
		root = insert(root, 2);
		root = insert(root, 4);
		root = insert(root, 5);
		root = insert(root, 6);
		System.out.println(root.getData());
		root = new RBNode(2, RBTreeColor.BLACK);
		RBNode rtL = new RBNode(1, RBTreeColor.BLACK);
		rtL.setParent(root);
		root.setLeft(rtL);
		RBNode rtR = new RBNode(3, RBTreeColor.BLACK);
		rtR.setParent(root);
		root.setRight(rtR);
		RBNode rtRR = new RBNode(4, RBTreeColor.RED);
		rtRR.setParent(rtR);
		rtR.setRight(rtRR);

		/*RBNode rtRRL = new RBNode(4, RBTreeColor.BLACK);
		rtRRL.setParent(rtRR);
		rtRR.setLeft(rtRRL);
		RBNode rtRRR = new RBNode(6, RBTreeColor.RED);
		rtRRR.setParent(rtRR);
		rtRR.setRight(rtRRR);
*/
		root = delete(root, rtR);
		System.out.println(root);
		
		TreeSet<String> set = new TreeSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		System.out.println(set);
		set.remove("3");
		System.out.println(set);
	}

	public static RBNode leftRotation(RBNode root, RBNode node) {
		RBNode rghtNodeBkp = getRight(node);
		node.setRight(getLeft(rghtNodeBkp));
		if (getLeft(rghtNodeBkp) != null) {
			getLeft(rghtNodeBkp).setParent(node);
		}
		rghtNodeBkp.setParent(getParent(node));
		if (getParent(node) == null) {
			root = rghtNodeBkp;
		} else if (node == getLeft(getParent(node))) {
			getParent(node).setLeft(rghtNodeBkp);
		} else {
			getParent(node).setRight(rghtNodeBkp);
		}
		rghtNodeBkp.setLeft(node);
		node.setParent(rghtNodeBkp);
		return root;
	}

	public static RBNode rightRotation(RBNode root, RBNode node) {
		RBNode leftNodeBkp = getLeft(node);
		node.setLeft(getRight(leftNodeBkp));
		if (getRight(leftNodeBkp) != null) {
			getRight(leftNodeBkp).setParent(node);
		}
		leftNodeBkp.setParent(getParent(node));
		if (getParent(node) == null) {
			root = leftNodeBkp;
		} else if (node == getLeft(getParent(node))) {
			getParent(node).setLeft(leftNodeBkp);
		} else {
			getParent(node).setRight(leftNodeBkp);
		}
		leftNodeBkp.setRight(node);
		node.setParent(leftNodeBkp);
		return root;
	}

	public static RBNode insert(RBNode root, int data) {
		RBNode y = null;
		RBNode x = root;
		while (x != null) {
			y = x;
			if (x.getData() < data) {
				x = x.getRight();
			} else if (x.getData() > data) {
				x = x.getLeft();
			} else {
				x = null;
			}
		}
		RBNode newNode = new RBNode(data, RBTreeColor.RED);
		newNode.setParent(y);
		if (root == null) {
			root = newNode;
		} else if (y.getData() < newNode.getData()) {
			y.setRight(newNode);
			fixUpRBTree(root, y.getRight());
		} else {
			y.setLeft(newNode);
			fixUpRBTree(root, y.getLeft());
		}

		return root;
	}

	public static void fixUpRBTree(RBNode root, RBNode node) {
		while ((node != null) && (node.getParent() != null)
				&& (getColor(getParent(node)) == RBTreeColor.RED)) {
			if (node == getLeft(getParent(getParent(node)))) {
				RBNode nodeRght = getRight(getParent(getParent(node)));
				if (getColor(nodeRght) == RBTreeColor.RED) {
					nodeRght.setColor(RBTreeColor.BLACK);
					getParent(node).setColor(RBTreeColor.BLACK);
					getParent(getParent(node)).setColor(RBTreeColor.RED);
					node = getParent(getParent(node));
				} else {
					if (node == getRight(getParent(node))) {
						node = getParent(node);
						leftRotation(root, node);
					}
					if (null != getParent(node)) {
						getParent(node).setColor(RBTreeColor.BLACK);
					}
					if (getParent(getParent(node)) != null) {
						getParent(getParent(node)).setColor(RBTreeColor.RED);
						rightRotation(root, getParent(getParent(node)));
					}
				}
			} else {
				RBNode nodeLeft = getLeft(getParent(getParent(node)));
				if (getColor(nodeLeft) == RBTreeColor.RED) {
					nodeLeft.setColor(RBTreeColor.BLACK);
					getParent(node).setColor(RBTreeColor.BLACK);
					getParent(getParent(node)).setColor(RBTreeColor.RED);
					node = getParent(getParent(node));
				} else {
					if (node == getLeft(getParent(node))) {
						node = getParent(node);
						rightRotation(root, node);
					}
					if (null != getParent(node)) {
						getParent(node).setColor(RBTreeColor.BLACK);
					}
					if (getParent(getParent(node)) != null) {
						getParent(getParent(node)).setColor(RBTreeColor.RED);
						leftRotation(root, getParent(getParent(node)));
					}
				}
			}
		}

	}

	/* Tree Delete */

	public static RBNode delete(RBNode root, RBNode nodeToDel) {
		RBNode temp = nodeToDel;
		RBNode nodeForFixUp = nodeToDel;
		RBTreeColor color = temp.getColor();
		if ((getLeft(nodeToDel) == null) && (getRight(nodeToDel) == null)) {
			if (color.getColor() == RBTreeColor.BLACK.getColor()) {
				root = fixUpDelete(root, nodeForFixUp);
			}
		} else {
			if ((getLeft(nodeToDel) == null) && (getRight(nodeToDel) != null)) {
				nodeForFixUp = getRight(nodeToDel) == null ? nodeToDel
						: getRight(nodeToDel);
				transplant(root, nodeToDel, getRight(nodeToDel));
			} else if ((getRight(nodeToDel) == null)
					&& (getLeft(nodeToDel) != null)) {
				nodeForFixUp = getLeft(nodeToDel) == null ? nodeToDel
						: getLeft(nodeToDel);
				transplant(root, nodeToDel, getLeft(nodeToDel));
			} else {
				temp = getSuccesor(nodeToDel);
				color = getColor(temp);
				nodeForFixUp = getRight(temp);
				if (getParent(temp) == nodeToDel) {
					if (nodeForFixUp != null) {
						nodeForFixUp.parent = temp;
					}
				} else {
					transplant(root, temp, getRight(temp));
					temp.setRight(getRight(nodeToDel));
					getRight(temp).parent = temp;
				}
				root = transplant(root, nodeToDel, temp);
				temp.setLeft(getLeft(nodeToDel));
				getLeft(temp).parent = temp;
				System.out.println();
				temp.setColor(getColor(nodeToDel));

			}
			if (color.getColor() == RBTreeColor.BLACK.getColor()) {
				fixUpDelete(root, nodeForFixUp);
			}
		}

		return root;
	}

	public static RBNode fixUpDelete(RBNode root, RBNode node) {
		while ((node != root) && (getColor(node) == RBTreeColor.BLACK)) {
			if (node == getLeft(getParent(node))) {
				RBNode siblings = getRight(getParent(node));
				if (getColor(siblings) == RBTreeColor.RED) {
					getParent(node).setColor(RBTreeColor.RED);
					if (siblings != null) {
						siblings.setColor(RBTreeColor.BLACK);
					}
					leftRotation(root, getParent(node));
					siblings = getRight(getParent(node));
				}
				if ((getColor(getRight(siblings)) == RBTreeColor.BLACK)
						&& (getColor(getLeft(siblings)) == RBTreeColor.BLACK)) {
					node = getParent(node);
					if (siblings != null) {
						siblings.setColor(RBTreeColor.RED);
					}
				} else {
					if (getColor(getRight(siblings)) == RBTreeColor.BLACK) {
						if (siblings != null) {
							siblings.setColor(RBTreeColor.RED);
						}
						getLeft(siblings).setColor(RBTreeColor.BLACK);
						rightRotation(root, siblings);
						siblings = getRight(getParent(node));
					}
					if (siblings != null) {
						siblings.setColor(getColor(getParent(node)));
					}
					getParent(node).setColor(RBTreeColor.BLACK);
					getRight(siblings).setColor(RBTreeColor.BLACK);
					root = leftRotation(root, getParent(node));
					node = root;
				}
			} else {
				RBNode siblings = getLeft(getParent(node));
				if (getColor(siblings) == RBTreeColor.RED) {
					if (siblings != null) {
						siblings.setColor(RBTreeColor.BLACK);
					}
					getParent(node).setColor(RBTreeColor.RED);
					rightRotation(root, getParent(node));
					siblings = getLeft(getParent(node));
				}
				if ((getColor(getLeft(siblings)) == RBTreeColor.BLACK)
						&& (getColor(getRight(siblings)) == RBTreeColor.BLACK)) {
					if (siblings != null) {
						siblings.setColor(RBTreeColor.RED);
					}
					node = getParent(node);
				} else {
					if (getColor(getLeft(siblings)) == RBTreeColor.BLACK) {
						siblings.setColor(RBTreeColor.RED);
						getRight(siblings).setColor(RBTreeColor.BLACK);
						leftRotation(root, siblings);
						siblings = getLeft(getParent(siblings));
					}
					if (siblings != null) {
						siblings.setColor(getColor(getParent(node)));
					}
					getParent(node).setColor(RBTreeColor.BLACK);
					getLeft(siblings).setColor(RBTreeColor.BLACK);
					rightRotation(root, getParent(node));
					node = root;
				}
			}
		}
		if (node != null) {
			node.setColor(RBTreeColor.BLACK);
		}
		return node;
	}

	public static RBNode transplant(RBNode root, RBNode node, RBNode transNode) {
		if ((root == null) || (getParent(node) == null)) {
			root = transNode;
		} else if (getLeft(getParent(node)) == node) {
			if (getParent(node) != null) {
				getParent(node).setLeft(transNode);
			}
		} else {
			if (getParent(node) != null) {
				node.parent.setRight(transNode);
			}
		}
		if (transNode != null) {
			transNode.parent = node.parent;
		}
		return root;
	}

	public static RBNode getSuccesor(RBNode node) {
		if (getRight(node) != null) {
			return getMin(getRight(node));
		}
		RBNode y = node.parent;
		while ((y != null) && (node == getRight(y))) {
			node = y;
			y = node.parent;
		}
		return y;
	}

	public static RBNode getMin(RBNode node) {
		if (getLeft(node) == null) {
			return node;
		}
		return getMin(getLeft(node));
	}

	private static RBTreeColor getColor(RBNode node) {
		return (node == null) ? RBTreeColor.BLACK : node.getColor();
	}

	private static RBNode getParent(RBNode node) {
		return (node == null) ? null : node.getParent();
	}

	private static RBNode getLeft(RBNode node) {
		return (node == null) ? null : node.getLeft();
	}

	private static RBNode getRight(RBNode node) {
		return (node == null) ? null : node.getRight();
	}
}
