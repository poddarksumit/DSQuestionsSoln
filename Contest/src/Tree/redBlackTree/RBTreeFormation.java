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

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * This class is used to
 * 
 * @author 583192 Version 1.0
 */
public class RBTreeFormation {

	static RBTNode root = null;

	public static void main(String[] args) {

		/*
		 * root = insert(null, "Brand", "Ad-hoc"); root = insert(root, "Brand",
		 * "Amiri"); root = insert(root, "Region", "Barossa"); root =
		 * insert(root, "Country", "Australia"); root = insert(root, "Region",
		 * "Yarra Valley"); root = insert(root, "Country", "Germany"); root =
		 * insert(root, "Title", "Jack Daniels"); root = insert(root, "Title",
		 * "Johnny Walker");
		 */
		TreeSet<String> set = new TreeSet<String>();
		set.add("b");
		set.add("r");
		set.add("c");
		set.add("t");
		set.add("a");
		set.add("ct");
		System.out.println(set);
		insert("b", "bc");
		insert("r", "bc");
		insert("c", "bc");
		insert("t", "bc");
		insert("a", "bc");
		insert("ct", "bc");
		iterate(root);
		System.out.println("node : " + root.getData());
		if (null != root.getLeft()) {
			System.out.println("left : " + root.getLeft().getData());
		}
		if (null != root.getRight()) {
			System.out.println("right : " + root.getRight().getData());
		}
		if (null != root.getParent()) {
			System.out.println("parent : " + root.getParent().getData());
		}
		System.out.println("values : " + root.getValuesArray() + "\n\n");
	}

	public static void iterate(RBTNode rootTemp) {
		if (rootTemp != null) {
			iterate(rootTemp.getLeft());
			System.out.println(rootTemp.getData());
			iterate(rootTemp.getRight());
		}
	}

	public static void insert(String data, String value) {

		ArrayList<String> values = new ArrayList<String>();
		RBTNode y = null;
		RBTNode x = root;
		boolean updateFilter = false;

		while (x != null) {
			y = x;
			if (x.getData().compareTo(data) < 0) {
				x = x.getRight();
			} else if (x.getData().compareTo(data) > 0) {
				x = x.getLeft();
			} else {
				x = null;
				updateFilter = true;
			}
		}
		if (!updateFilter) {
			RBTNode newNode = new RBTNode(data, RBTreeColor.RED);
			newNode.setParent(y);
			values.add(value);
			if (y == null) {
				newNode.setColor(RBTreeColor.BLACK);
				newNode.setValuesArray(values);
				root = newNode;
			} else if (y.getData().compareTo(newNode.getData()) < 0) {
				newNode.setValuesArray(values);
				y.setRight(newNode);
			} else if (y.getData().compareTo(newNode.getData()) > 0) {
				newNode.setValuesArray(values);
				y.setLeft(newNode);
				
			}
			fixUpRBTree(root,newNode);
		} else {
			// tree = getTree(y, values, value);
			getTree(y, values, value);
		}

	}

	public static void fixUpRBTree(RBTNode tree, RBTNode node) {
		while ((node != null) && (node.getParent() != null)
				&& (getColor(getParent(node)) == RBTreeColor.RED)) {
			if (getParent(node) == getLeft(getParent(getParent(node)))) {
				RBTNode nodeRght = getRight(getParent(getParent(node)));
				if (getColor(nodeRght) == RBTreeColor.RED) {
					nodeRght.setColor(RBTreeColor.BLACK);
					getParent(node).setColor(RBTreeColor.BLACK);
					getParent(getParent(node)).setColor(RBTreeColor.RED);
					node = getParent(getParent(node));
				} else {
					if (node == getRight(getParent(node))) {
						node = getParent(node);
						leftRotation(node);
					}
					if (null != getParent(node)) {
						getParent(node).setColor(RBTreeColor.BLACK);
					}
					if (getParent(getParent(node)) != null) {
						getParent(getParent(node)).setColor(RBTreeColor.RED);
						rightRotation(getParent(getParent(node)));
					}
				}
			} else {
				RBTNode nodeLeft = getLeft(getParent(getParent(node)));
				if (getColor(nodeLeft) == RBTreeColor.RED) {
					nodeLeft.setColor(RBTreeColor.BLACK);
					getParent(node).setColor(RBTreeColor.BLACK);
					getParent(getParent(node)).setColor(RBTreeColor.RED);
					node = getParent(getParent(node));
				} else {
					if (node == getLeft(getParent(node))) {
						node = getParent(node);
						rightRotation(node);
					}
					if (null != getParent(node)) {
						getParent(node).setColor(RBTreeColor.BLACK);
					}
					if (getParent(getParent(node)) != null) {
						getParent(getParent(node)).setColor(RBTreeColor.RED);
						leftRotation(getParent(getParent(node)));
					}
				}
			}
		}
		root.setColor(RBTreeColor.BLACK);
	}

	public static void leftRotation(RBTNode node) {
		RBTNode rghtNodeBkp = getRight(node);
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
	}

	public static void rightRotation(RBTNode node) {
		RBTNode leftNodeBkp = getLeft(node);
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
	}

	private static void getTree(RBTNode y, ArrayList<String> values,
			String value) {

		RBTNode z = null;

		if ((null != y) && (y.getValuesArray().size() > 0)) {
			values = y.getValuesArray();
		}
		values.add(value);
		y.setValuesArray(values);
		/**
		 * while (null != getParent(node)) { z = node; if ((null !=
		 * getLeft(getParent(node))) && (node.getData().compareTo(
		 * getLeft(getParent(node)).getData()) == 0)) {
		 * getParent(node).setLeft(node); } else if ((null !=
		 * getRight(getParent(node))) && (node.getData().compareTo(
		 * getRight(getParent(node)).getData()) == 0)) {
		 * getParent(node).setRight(node); } node = getParent(node); }
		 * 
		 * return node;
		 */
	}

	private static RBTreeColor getColor(RBTNode node) {
		return (node == null) ? RBTreeColor.BLACK : node.getColor();
	}

	private static RBTNode getParent(RBTNode node) {
		return (node == null) ? null : node.getParent();
	}

	private static RBTNode getLeft(RBTNode node) {
		return (node == null) ? null : node.getLeft();
	}

	private static RBTNode getRight(RBTNode node) {
		return (node == null) ? null : node.getRight();
	}

}
