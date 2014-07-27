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

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class RBNode {

    private int data;
    private RBNode left;
    private RBNode right;
    public RBNode parent;
    private RBTreeColor color;

    /**
     * 
     */
    public RBNode() {
    }

    public RBNode getParent() {
	return parent;
    }

    public void setParent(RBNode parent) {
	this.parent = parent;
    }

    public RBTreeColor getColor() {
	return color;
    }

    public void setColor(RBTreeColor color) {
	this.color = color;
    }

    /**
     * @return the data
     */
    public int getData() {
	return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(int data) {
	this.data = data;
    }

    /**
     * @return the left
     */
    public RBNode getLeft() {
	return left;
    }

    /**
     * @param left
     *            the left to set
     */
    public void setLeft(RBNode left) {
	this.left = left;
    }

    /**
     * @return the right
     */
    public RBNode getRight() {
	return right;
    }

    /**
     * @param right
     *            the right to set
     */
    public void setRight(RBNode right) {
	this.right = right;
    }

    /**
     * @param data
     * @param color
     */
    public RBNode(int data, RBTreeColor color) {
	super();
	this.data = data;
	this.color = color;
    }

}
