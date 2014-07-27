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


/**
 * This class is used to
 * 
 * @author 583192 Version 1.0
 */
public class RBTNode {

    private String data;
    public ArrayList<String> valuesArray;
    private RBTNode left;
    private RBTNode right;
    public RBTNode parent;
    private RBTreeColor color;

    /**
     * 
     */
    public RBTNode() {
    }

    public RBTNode getParent() {
	return parent;
    }

    public void setParent(RBTNode parent) {
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
    public String getData() {
	return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(String data) {
	this.data = data;
    }

    /**
     * @return the left
     */
    public RBTNode getLeft() {
	return left;
    }

    /**
     * @param left
     *            the left to set
     */
    public void setLeft(RBTNode left) {
	this.left = left;
    }

    /**
     * @return the right
     */
    public RBTNode getRight() {
	return right;
    }

    /**
     * @param right
     *            the right to set
     */
    public void setRight(RBTNode right) {
	this.right = right;
    }

    /**
     * @return the valuesArray
     */
    public ArrayList<String> getValuesArray() {
	return valuesArray;
    }

    /**
     * @param valuesArray
     *            the valuesArray to set
     */
    public void setValuesArray(ArrayList<String> valuesArray) {
	this.valuesArray = valuesArray;
    }

    /**
     * @param data
     * @param color
     */
    public RBTNode(String data, RBTreeColor color) {
	super();
	this.data = data;
	this.color = color;
    }

}
